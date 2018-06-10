package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){
        //Given
        Set<Book> libraryaBooks = new HashSet<>();
        libraryaBooks.add(new Book("Author1", "Title1", 2000, "1001"));
        libraryaBooks.add(new Book("Author2", "Title2", 2002, "1002"));
        libraryaBooks.add(new Book("Author3", "Title3", 2004, "1003"));
        libraryaBooks.add(new Book("Author4", "Title4", 2006, "1004"));
        libraryaBooks.add(new Book("Author5", "Title5", 2008, "1005"));
        libraryaBooks.add(new Book("Author6", "Title6", 2010, "1006"));
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(libraryaBooks);
        //Then
        Assert.assertEquals(2005, median);
    }
}
