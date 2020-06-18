package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationName implements Serializable {
    private String name;
    private String URL;

    public OrganizationName() {
    }

    public OrganizationName(String name, String url) {
        Objects.requireNonNull(this.name = name);
        this.URL = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return URL;
    }

    @Override
    public String toString() {
        return name + ", URL='" + URL + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationName that = (OrganizationName) o;

        if (!name.equals(that.name)) return false;
        return Objects.equals(URL, that.URL);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (URL != null ? URL.hashCode() : 0);
        return result;
    }
}
