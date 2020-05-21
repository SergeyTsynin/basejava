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
}
