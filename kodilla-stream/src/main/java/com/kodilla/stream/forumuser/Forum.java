package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Forum() {
        forumUsersList.add(new ForumUser(101,"User1", 'M', 1985, 12, 1, 2));
        forumUsersList.add(new ForumUser(102,"User2", 'M', 2000, 11, 2, 3));
        forumUsersList.add(new ForumUser(103,"User3", 'M', 1990, 10, 3, 5));
        forumUsersList.add(new ForumUser(104,"User4", 'M', 1995, 9, 4, 0));
        forumUsersList.add(new ForumUser(105,"User5", 'K', 2002, 8, 3, 32));
        forumUsersList.add(new ForumUser(106,"User6", 'K', 1999, 6, 2, 3));
        forumUsersList.add(new ForumUser(107,"User7", 'M', 1997, 1, 1, 20));
    }
    public List<ForumUser> getUserList(){
        return new ArrayList<>(forumUsersList);
    }
}
