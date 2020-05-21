package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final String TITLE;
    private final String DESCRIPTION;
    private final LocalDate DATE_BEGIN;
    private final LocalDate DATE_END;
    private final OrganizationName NAME;

    public Organization(String title, String description, OrganizationName name, LocalDate dateBegin, LocalDate dateEnd) {
        Objects.requireNonNull(this.TITLE = title);
        Objects.requireNonNull(this.DESCRIPTION = description);
        Objects.requireNonNull(this.NAME = name);
        Objects.requireNonNull(this.DATE_BEGIN = dateBegin);
        Objects.requireNonNull(this.DATE_END = dateEnd);
    }

    @Override
    public String toString() {
        return NAME + "\r\n" +
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
        if (!DESCRIPTION.equals(that.DESCRIPTION)) return false;
        if (!DATE_BEGIN.equals(that.DATE_BEGIN)) return false;
        if (!DATE_END.equals(that.DATE_END)) return false;
        return NAME.equals(that.NAME);
    }

    @Override
    public int hashCode() {
        int result = TITLE.hashCode();
        result = 31 * result + DESCRIPTION.hashCode();
        result = 31 * result + DATE_BEGIN.hashCode();
        result = 31 * result + DATE_END.hashCode();
        result = 31 * result + NAME.hashCode();
        return result;
    }
}
