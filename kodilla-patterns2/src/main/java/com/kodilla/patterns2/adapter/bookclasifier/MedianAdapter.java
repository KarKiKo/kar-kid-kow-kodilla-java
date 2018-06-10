package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> bookMap = new HashMap<>();
        for (com.kodilla.patterns2.adapter.bookclasifier.librarya.Book libraryaBook : bookSet) {
            bookMap.put(new BookSignature(libraryaBook.getSignature()),
                    new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(libraryaBook.getAuthor(),
                    libraryaBook.getTitle(), libraryaBook.getPublicationYear()));
        }
        return medianPublicationYear(bookMap);
    }
}
