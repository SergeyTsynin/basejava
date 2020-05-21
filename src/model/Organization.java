package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Organization {
    private final String TITLE;
    private final String DESCRIPTION;
    private final Date DATE_BEGIN;
    private final Date DATE_END;
    private final OrganizationName NAME;

    public Organization(String title, String description, OrganizationName name, Date dateBegin, Date dateEnd) {
        Objects.requireNonNull(this.TITLE = title);
        Objects.requireNonNull(this.DESCRIPTION = description);
        Objects.requireNonNull(this.NAME = name);
        Objects.requireNonNull(this.DATE_BEGIN = dateBegin);
        Objects.requireNonNull(this.DATE_END = dateEnd);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/yyyy");
        return NAME + "\r\n" +
                formatDate.format(DATE_BEGIN) + " - " +
                formatDate.format(DATE_END) + "\r\n" +
                TITLE + "\r\n" +
                DESCRIPTION;
    }
}
