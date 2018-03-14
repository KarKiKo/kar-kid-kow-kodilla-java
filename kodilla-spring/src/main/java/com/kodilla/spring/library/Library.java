package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
// 1st and 2nd method  private LibraryDbController libraryDbController;


    @Autowired
    private LibraryDbController libraryDbController;
// 1st method
// @Autowired
// public Library(final LibraryDbController libraryDbController) {
/* 2nd method   public void setLibraryDbController (LibraryDbController libraryDbController){
        this.libraryDbController = libraryDbController;
    }*/

/*1st method    public Library() {
    }*/

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}