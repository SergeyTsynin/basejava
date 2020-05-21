package model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;

    private final String fullName;

    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(this.uuid = uuid);
        Objects.requireNonNull(this.fullName = fullName);
    }

    public String getUuid() {
        return uuid;
    }

    public Map<ContactType, String> getContactsMap() {
        return contacts;
    }

    public String getContact(ContactType contactType) {
        return contacts.get(contactType);
    }

    public Map<SectionType, Section> getSectionsMap() {
        return sections;
    }

    public Section getSection(SectionType sectionType) {
        return sections.get(sectionType);
    }

    public void setContact(ContactType type, String text) {
        contacts.put(type, text);
    }

    public void setSection(SectionType type, Section section) {
        sections.put(type, section);
    }

    public String getAll() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<ContactType, String> pair : contacts.entrySet()) {
            result.append(pair.getKey().getTitle()).append(" ").append(pair.getValue()).append("\r\n");
        }
        result.append("\r\n");
        for (Map.Entry<SectionType, Section> pair : sections.entrySet()) {
            result.append(pair.getKey().getTitle()).append("\r\n");
            result.append(pair.getValue()).append("\r\n\r\n");
        }
        return String.valueOf(result);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return uuid + " - " + fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int compareTo(Resume resume) {
        int fullNameCompare = fullName.compareTo(resume.fullName);
        return fullNameCompare == 0 ? uuid.compareTo(resume.uuid) : fullNameCompare;
    }
}
