package model;

import java.util.Objects;

public class TextSection extends Section {
    private final String CONTENT;

    public TextSection(String content) {
        Objects.requireNonNull(this.CONTENT = content);
    }

    public String getContent() {
        return CONTENT;
    }

    @Override
    public String toString() {
        return CONTENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextSection that = (TextSection) o;

        return CONTENT.equals(that.CONTENT);
    }

    @Override
    public int hashCode() {
        return CONTENT.hashCode();
    }
}
