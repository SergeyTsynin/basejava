package model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final OrganizationName name;
    private final List<WhatDidIDoInThisPlace> whatDidIDoInThisPlace;

    public Organization(OrganizationName name, List<WhatDidIDoInThisPlace> whatDidIDoInThisPlace) {
        Objects.requireNonNull(this.name = name);
        Objects.requireNonNull(this.whatDidIDoInThisPlace = whatDidIDoInThisPlace);
    }

    @Override
    public String toString() {
        return "\r\n" +
                name + "\r\n" +
                whatDidIDoInThisPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!name.equals(that.name)) return false;
        return whatDidIDoInThisPlace.equals(that.whatDidIDoInThisPlace);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + whatDidIDoInThisPlace.hashCode();
        return result;
    }
}
