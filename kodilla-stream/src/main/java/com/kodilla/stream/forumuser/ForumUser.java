package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final Integer uniqueIdentifier;
    private final String userName;
    private final char gender;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(Integer uniqueIdentifier, String userName, char gender, int yearOfBirth, int monthOfBirth,
                     int dayOfBirth, int numberOfPosts) {
        this.uniqueIdentifier = uniqueIdentifier;
        this.userName = userName;
        this.gender = gender;
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.numberOfPosts = numberOfPosts;
    }

    public int getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public String getUserName() {
        return userName;
    }

    public char getGender() {
        return gender;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "uniqueIdentifier=" + uniqueIdentifier +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
