package model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final String TITLE;
    private final String DESCRIPTION;
    private final LocalDate DATE_BEGIN;
    private final LocalDate DATE_END;
    private final OrganizationName NAME;

    public Organization(OrganizationName name, String title, String description, LocalDate dateBegin, LocalDate dateEnd) {
        Objects.requireNonNull(this.TITLE = title);
        this.DESCRIPTION = description;
        Objects.requireNonNull(this.NAME = name);
        Objects.requireNonNull(this.DATE_BEGIN = dateBegin);
        Objects.requireNonNull(this.DATE_END = dateEnd);
    }

    @Override
    public String toString() {
        return "\r\n" +
                NAME + "\r\n" +
                DATE_BEGIN + " - " +
                DATE_END + "\r\n" +
                TITLE + "\r\n" +
                DESCRIPTION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!TITLE.equals(that.TITLE)) return false;
        if (!Objects.equals(DESCRIPTION, that.DESCRIPTION)) return false;
        if (!DATE_BEGIN.equals(that.DATE_BEGIN)) return false;
        if (!DATE_END.equals(that.DATE_END)) return false;
        return NAME.equals(that.NAME);
    }

    @Override
    public int hashCode() {
        int result = TITLE.hashCode();
        result = 31 * result + (DESCRIPTION != null ? DESCRIPTION.hashCode() : 0);
        result = 31 * result + DATE_BEGIN.hashCode();
        result = 31 * result + DATE_END.hashCode();
        result = 31 * result + NAME.hashCode();
        return result;
    }
}
