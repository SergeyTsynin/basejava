package model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section {
    private final List<Organization> ORGANIZATION;

    public OrganizationSection(List<Organization> organization) {
        Objects.requireNonNull(this.ORGANIZATION = organization);
    }

    @Override
    public String toString() {
        return "OrganizationSection{" +
                "ORGANIZATION=" + ORGANIZATION +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return ORGANIZATION.equals(that.ORGANIZATION);
    }

    @Override
    public int hashCode() {
        return ORGANIZATION.hashCode();
    }
}
