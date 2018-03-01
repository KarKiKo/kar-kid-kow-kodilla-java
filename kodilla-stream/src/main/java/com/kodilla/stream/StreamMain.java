package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.NativeString.*;

public class StreamMain {
    public static void main(String[] args) {

        Forum forumUsersToStream = new Forum();
        Map<Integer, ForumUser> mapOfForumUsers = forumUsersToStream.getUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().getYear() < 1999)
                .filter(forumUser -> forumUser.getNumberOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getUniqueIdentifier, forumUser -> forumUser));
        System.out.println("# elements: " + mapOfForumUsers.size());
        mapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}