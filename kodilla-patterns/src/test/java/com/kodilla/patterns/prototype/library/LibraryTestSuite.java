package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks(){
        //Given
        Library mainLibrary = new Library ("Main Library");
        IntStream.iterate(1, n -> n+1)
            .limit(15)
            .forEach(n -> mainLibrary.getBooks().add(new Book("Title #" + n, "Author #" + n, LocalDate.of(2000 + n,1,1))));

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = mainLibrary.shallowCopy();
            shallowClonedLibrary.setName("Shallow cloned library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = mainLibrary.deepCopy();
            deepClonedLibrary.setName("Deep cloned library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        shallowClonedLibrary.getBooks().remove(shallowClonedLibrary.getBooks().iterator().next());
        //Then
        System.out.println(mainLibrary);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(14, mainLibrary.getBooks().size());
        Assert.assertEquals(14,shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(15,deepClonedLibrary.getBooks().size());

        Assert.assertEquals(shallowClonedLibrary.getBooks(),mainLibrary.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(),mainLibrary.getBooks());
    }
}
