package model;

import java.util.List;

public class ListSection extends Section {
    private List<String> content;

    ListSection(List<String> content) {
        this.content = content;
    }

    public List<String> getContent() {
        return content;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String key : content) {
            result.append(key).append("\r\n");
        }
        return String.valueOf(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
