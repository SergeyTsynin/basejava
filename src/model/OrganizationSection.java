package model;

import java.util.List;

public class OrganizationSection extends Section {
    List<Organization> organization;

    OrganizationSection(List<Organization> organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "OrganizationSection{" +
                "organization=" + organization +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organization.equals(that.organization);
    }

    @Override
    public int hashCode() {
        return organization.hashCode();
    }
}
