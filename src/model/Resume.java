package model;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;

    private final String fullName;

    private final Map<ContactType, String> contact = new EnumMap<>(ContactType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
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
    public int compareTo(Resume resume) {
        int fullNameCompare = fullName.compareTo(resume.fullName);
        return fullNameCompare == 0 ? uuid.compareTo(resume.uuid) : fullNameCompare;
    }

    public void setPhone(String phone) {
        contact.put(ContactType.PHONE, phone);
    }

    public void setSkype(String skype) {
        contact.put(ContactType.SKYPE, skype);
    }

    public void setEmail(String email) {
        contact.put(ContactType.EMAIL, email);
    }

    public void setLinkedin(String linkedin) {
        contact.put(ContactType.LINKEDIN, linkedin);
    }

    public void setGithub(String github) {
        contact.put(ContactType.GITHUB, github);
    }

    public void setStackoverflow(String stackoverflow) {
        contact.put(ContactType.STACKOVERFLOW, stackoverflow);
    }

    public void setHomepage(String homepage) {
        contact.put(ContactType.HOMEPAGE, homepage);
    }

    public String getAll() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<ContactType, String> pair : contact.entrySet()) {
            result.append(pair.getKey().getTitle()).append(" ").append(pair.getValue()).append("\r\n");
        }
        return String.valueOf(result);
    }
}
