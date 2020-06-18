package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    private OrganizationName name;
    private List<Position> position;

    public Organization(OrganizationName name, List<Position> position) {
        Objects.requireNonNull(this.name = name);
        Objects.requireNonNull(this.position = position);
    }

    public Organization() {
    }

    @Override
    public String toString() {
        return "\r\n" +
                name + "\r\n" +
                position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!name.equals(that.name)) return false;
        return position.equals(that.position);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }
}
