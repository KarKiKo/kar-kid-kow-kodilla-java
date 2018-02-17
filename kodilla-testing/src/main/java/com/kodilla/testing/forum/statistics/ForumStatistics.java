package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;
import java.util.List;

public class ForumStatistics {

    Statistics statistics;
    private int forumUsersQuantity;
    private int forumPostsQuantity;
    private int forumCommentsQuantity;
    private double postsQuantityPerUserAvg;
    private double commentsQuantityPerUserAvg;
    private double commentsQuantityPerPostsAvg;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics){
        forumUsersQuantity = statistics.usersNames().size();
        forumPostsQuantity = statistics.postsCount();
        forumCommentsQuantity = statistics.commentsCount();
        if (forumUsersQuantity !=0) {
            postsQuantityPerUserAvg = forumPostsQuantity / forumUsersQuantity;
            commentsQuantityPerUserAvg = forumCommentsQuantity / forumUsersQuantity;
        }
        if (forumUsersQuantity != 0 && forumPostsQuantity != 0) {
            commentsQuantityPerPostsAvg = forumCommentsQuantity / forumPostsQuantity;
        } else {
            forumCommentsQuantity = 0;
        }
    }

    public String showStatistics() {
        String ShowStatistics;
        ShowStatistics = "Liczba uzytkownikow: " + forumUsersQuantity + "\n" + "Liczba postow na forum: " +
                forumPostsQuantity + "\n" + "Liczba komentarzy na forum: " + forumCommentsQuantity +
                "\n" + "Liczba postów na użytkownika: " + postsQuantityPerUserAvg + "\n" +
                "Liczba komentarzy na użytkownika: " + commentsQuantityPerUserAvg + "\n" +
                 "Liczba komentarzy na post: " + commentsQuantityPerPostsAvg;
        System.out.println(ShowStatistics);
        return ShowStatistics;
    }

    public int getForumUsersQuantity() {
        return forumUsersQuantity;
    }

    public int getForumPostsQuantity() {
        return forumPostsQuantity;
    }

    public int getForumCommentsQuantity() {
        return forumCommentsQuantity;
    }

    public double getPostsQuantityPerUserAvg() {
        return postsQuantityPerUserAvg;
    }

    public double getCommentsQuantityPerUserAvg() {
        return commentsQuantityPerUserAvg;
    }

    public double getCommentsQuantityPerPostsAvg() {
        return commentsQuantityPerPostsAvg;
    }
}
