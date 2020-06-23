package storage.serialization;

import model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerialization implements StreamSerialization {
    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());

            Map<ContactType, String> contacts = r.getContactsMap();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }

            Map<SectionType, Section> sections = r.getSectionsMap();
            dos.writeInt(sections.size());
            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
                SectionType sectionType = entry.getKey();
                dos.writeUTF(sectionType.name());
                switch (sectionType) {
                    case OBJECTIVE:
                    case PERSONAL:
                        dos.writeUTF(((TextSection) entry.getValue()).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeStringList(((ListSection) entry.getValue()).getContent(), dos);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeOrganizations(((OrganizationsSection) entry.getValue()).getContent(), dos);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + sectionType);
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);

            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.setContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }

            size = dis.readInt();
            for (int i = 0; i < size; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                switch (sectionType) {
                    case OBJECTIVE:
                    case PERSONAL:
                        resume.setSection(sectionType, new TextSection(dis.readUTF()));
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        resume.setSection(sectionType, new ListSection(readStringList(dis)));
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        resume.setSection(sectionType, new OrganizationsSection(readOrganizations(dis)));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + sectionType);
                }
            }
            return resume;
        }
    }

    private void writeStringList(List<String> list, DataOutputStream dos) throws IOException {
        dos.writeInt(list.size());
        for (String s : list) {
            dos.writeUTF(s);
        }
    }

    private List<String> readStringList(DataInputStream dis) throws IOException {
        int size = dis.readInt();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(dis.readUTF());
        }
        return result;
    }

    private void writeOrganizations(List<Organization> content, DataOutputStream dos) throws IOException {
        dos.writeInt(content.size());
        for (Organization org : content) {
            dos.writeUTF(org.getName().getName());
            dos.writeUTF(org.getName().getUrl());
            List<Position> positions = org.getPositions();
            dos.writeInt(org.getPositions().size());
            for (Position position : positions) {
                dos.writeUTF(position.getTitle());
                dos.writeUTF((position.getDescription() == null) ? "null" : position.getDescription());
                dos.writeUTF(position.getDateBegin().toString());
                dos.writeUTF(position.getDateEnd().toString());
            }
        }
    }

    private List<Organization> readOrganizations(DataInputStream dis) throws IOException {
        int size = dis.readInt();
        List<Organization> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String name = dis.readUTF();
            String url = dis.readUTF();
            int positionSize = dis.readInt();
            List<Position> positions = new ArrayList<>();
            for (int j = 0; j < positionSize; j++) {
                String title = dis.readUTF();
                String description = dis.readUTF();
                if (description.equals("null")) description = null;
                LocalDate dateBegin = LocalDate.parse(dis.readUTF());
                LocalDate dateEnd = LocalDate.parse(dis.readUTF());
                positions.add(new Position(title, description, dateBegin, dateEnd));
            }
            result.add(new Organization(new OrganizationName(name, url), positions));
        }
        return result;
    }
}
/*
теперь надо зарефакторить запись всех коллекций (т.е. все for в doWrite) через функц интерфейс
посмотри на реализацию forEach
default void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);
    for (T t : this) {
        action.accept(t);
    }
}
надо сделать что-то подобное, т.к. использование готового forEach в нашей ситуации не подходит,
нам нужен метод который прокидывает IOException дальше, и свой кастомный функциональный интерфейс
(как записывать каждый отд элемент коллекции) который тоже прокидывает IOException
 */
