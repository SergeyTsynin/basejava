package model;

import java.util.Objects;

public class TextSection extends Section {
    private String content;

    public TextSection(String content) {
        this.content = Objects.requireNonNull(content);
    }

    public TextSection() {
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
