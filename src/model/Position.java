package model;

import util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Position implements Serializable {
    private String title;
    private String description;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateBegin;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateEnd;

    public Position(String title, String description, LocalDate dateBegin, LocalDate dateEnd) {
        Objects.requireNonNull(this.title = title);
        this.description = description;
        Objects.requireNonNull(this.dateBegin = dateBegin);
        Objects.requireNonNull(this.dateEnd = dateEnd);
    }

    public Position() {
    }

    @Override
    public String toString() {
        return dateBegin + " - " +
                dateEnd + "\r\n" +
                title + "\r\n" +
                (description == null ? "" : description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position that = (Position) o;

        if (!title.equals(that.title)) return false;
        if (!Objects.equals(description, that.description)) return false;
        if (!dateBegin.equals(that.dateBegin)) return false;
        return dateEnd.equals(that.dateEnd);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + dateBegin.hashCode();
        result = 31 * result + dateEnd.hashCode();
        return result;
    }
}

