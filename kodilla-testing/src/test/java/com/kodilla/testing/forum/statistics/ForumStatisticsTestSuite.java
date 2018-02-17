package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    @Test
    public void testCalculateStatistics() {
        //Given
        Statistics mockStatistics = mock(Statistics.class);
        List<String> usersList = new ArrayList<String>();
        for(int i = 0; i < 100; i++) {
            usersList.add("Imie Nazwisko #" + i);
        }
        when(mockStatistics.usersNames()).thenReturn(usersList);
        int postsQuantity = 500;
        if (usersList.size() == 0) {postsQuantity = 0;};
        when(mockStatistics.postsCount()).thenReturn(postsQuantity);
        int commentsQuantity = 1000;
        if (postsQuantity == 0 || usersList.size() == 0) {commentsQuantity = 0;};
        when(mockStatistics.commentsCount()).thenReturn(commentsQuantity);

        ForumStatistics calculatedStatistics = new ForumStatistics(mockStatistics);
        calculatedStatistics.calculateAdvStatistics(mockStatistics);
        calculatedStatistics.showStatistics();
        //When
        int liczbaUzytkownikow = calculatedStatistics.getForumUsersQuantity();
        int liczbaPostow = calculatedStatistics.getForumPostsQuantity();
        int liczbaKomentarzy = calculatedStatistics.getForumCommentsQuantity();
        double liczbaPostowNaUzytkownika = calculatedStatistics.getPostsQuantityPerUserAvg();
        double liczbaKomentarzyNaUzytkownika = calculatedStatistics.getCommentsQuantityPerUserAvg();
        double liczbaKomentarzyNaPost = calculatedStatistics.getCommentsQuantityPerPostsAvg();
        //Then
        Assert.assertEquals(usersList.size(), liczbaUzytkownikow);
        Assert.assertEquals(postsQuantity, liczbaPostow);
        Assert.assertEquals(commentsQuantity, liczbaKomentarzy);
        if(usersList.size() != 0) {Assert.assertEquals(postsQuantity/usersList.size(), liczbaPostowNaUzytkownika, 0);};
        if(usersList.size() != 0) {Assert.assertEquals(commentsQuantity/usersList.size(), liczbaKomentarzyNaUzytkownika, 0);};
        if(postsQuantity != 0) {Assert.assertEquals(commentsQuantity /postsQuantity, liczbaKomentarzyNaPost, 0);};
    }
}
