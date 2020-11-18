package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    void testGetBooks() throws CloneNotSupportedException {
        //Given
        Library library = new Library("List of books");
        IntStream.iterate(1, n -> n +1)
                .limit(5)
                .forEach(n -> library.getBooks().add(new Book("title" + n,
                        "author" + n, LocalDate.of(2020, 10, 05))));
        //When
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println("The problem is: " + e + ".");
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e){
                System.out.println("The problem is: " + e + ".");
        }

        //Then
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, clonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
        System.out.println(deepClonedLibrary);
    }
}

