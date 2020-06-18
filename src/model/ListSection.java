package model;

import java.util.List;
import java.util.Objects;

public class ListSection extends Section {
    private List<String> CONTENT;

    public ListSection(List<String> content) {
        Objects.requireNonNull(this.CONTENT = content);
    }

    public ListSection() {
    }

    public List<String> getContent() {
        return CONTENT;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String key : CONTENT) {
            result.append(key).append("\r\n");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return CONTENT.equals(that.CONTENT);
    }

    @Override
    public int hashCode() {
        return CONTENT.hashCode();
    }
}
