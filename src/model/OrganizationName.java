package model;

public class OrganizationName {
    private String name;
    private String url;

    public OrganizationName(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return name + ", url='" + url + '\'';
    }
}
