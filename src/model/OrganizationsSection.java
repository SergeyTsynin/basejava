package model;

import java.util.List;
import java.util.Objects;

public class OrganizationsSection extends Section {
    private final List<Organization> organizations;

    public OrganizationsSection(List<Organization> organizations) {
        Objects.requireNonNull(this.organizations = organizations);
    }

    @Override
    public String toString() {
        return "OrganizationsSection{" +
                "organizations=" + organizations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationsSection that = (OrganizationsSection) o;

        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }
}
