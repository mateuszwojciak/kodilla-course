package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library extends Prototype<Library> {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Library [" + name + ", \n" + books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>(books);
        return clonedLibrary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) &&
                Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }
}