package model;

import java.util.Objects;

public class OrganizationName {
    private final String NAME;
    private final String URL;

    public OrganizationName(String name, String url) {
        Objects.requireNonNull(this.NAME = name);
        Objects.requireNonNull(this.URL = url);
    }

    public String getName() {
        return NAME;
    }

    public String getUrl() {
        return URL;
    }

    @Override
    public String toString() {
        return NAME + ", URL='" + URL + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationName that = (OrganizationName) o;

        if (!NAME.equals(that.NAME)) return false;
        return URL.equals(that.URL);
    }

    @Override
    public int hashCode() {
        int result = NAME.hashCode();
        result = 31 * result + URL.hashCode();
        return result;
    }
}
