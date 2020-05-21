package model;

import java.util.List;
import java.util.Objects;

public class OrganizationsSection extends Section {
    private final List<Organization> ORGANIZATIONS;

    public OrganizationsSection(List<Organization> organizations) {
        Objects.requireNonNull(this.ORGANIZATIONS = organizations);
    }

    @Override
    public String toString() {
        return "OrganizationsSection{" +
                "ORGANIZATIONS=" + ORGANIZATIONS +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationsSection that = (OrganizationsSection) o;

        return ORGANIZATIONS.equals(that.ORGANIZATIONS);
    }

    @Override
    public int hashCode() {
        return ORGANIZATIONS.hashCode();
    }
}
