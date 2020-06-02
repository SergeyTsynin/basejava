package model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final String title;
    private final String description;
    private final LocalDate dateBegin;
    private final LocalDate dateEnd;
    private final OrganizationName name;

    public Organization(OrganizationName name, String title, String description, LocalDate dateBegin, LocalDate dateEnd) {
        Objects.requireNonNull(this.title = title);
        this.description = description;
        Objects.requireNonNull(this.name = name);
        Objects.requireNonNull(this.dateBegin = dateBegin);
        Objects.requireNonNull(this.dateEnd = dateEnd);
    }

    @Override
    public String toString() {
        return "\r\n" +
                name + "\r\n" +
                dateBegin + " - " +
                dateEnd + "\r\n" +
                title + "\r\n" +
                description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!title.equals(that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!dateBegin.equals(that.dateBegin)) return false;
        if (!dateEnd.equals(that.dateEnd)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + dateBegin.hashCode();
        result = 31 * result + dateEnd.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
