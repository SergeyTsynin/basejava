package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Organization {
    private String title;
    private String description;
    private Date dateBegin;
    private Date dateEnd;
    private OrganizationName name;

    public Organization(String title, String description, OrganizationName name, Date dateBegin, Date dateEnd) {
        this.title = title;
        this.description = description;
        this.name = name;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/yyyy");
        return name + "\r\n" +
                formatDate.format(dateBegin) + " - " +
                formatDate.format(dateEnd) + "\r\n" +
                title + "\r\n" +
                description;
    }
}
