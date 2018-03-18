package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publisher.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSocialPublisher(){
    //Given
        User millenials = new Millenials("Tomasz K.");
        User yGeneration = new YGeneration("Piot T.");
        User zGeneration = new ZGeneration("Kryspin M.");
    //When
        String tomaszSocialMedium = millenials.sharePost();
        String piotrSocialMedium = yGeneration.sharePost();
        String kryspinSocialMedium = zGeneration.sharePost();
    //Then
        Assert.assertEquals("User prefers Facebook as a social medium", tomaszSocialMedium);
        Assert.assertEquals("User prefers Twitter as a social medium", piotrSocialMedium);
        Assert.assertEquals("User prefers Snapchat as a social medium", kryspinSocialMedium);
    }

    @Test
    public void testIndividualSocialPublisher(){
        //Given
        User millenialsWhoPrefersSnapChat = new Millenials("Anna N.");
        User zGenerationWhoPrefersFacebook = new ZGeneration("Magda M.");
        //When
        millenialsWhoPrefersSnapChat.setSocialPublisher(new SnapchatPublisher());
        String aniasSocialPublisherIndividualPreferences = millenialsWhoPrefersSnapChat.sharePost();
        zGenerationWhoPrefersFacebook.setSocialPublisher(new FacebookPublisher());
        String magdaSocialPublisherIndividualPreferences = zGenerationWhoPrefersFacebook.sharePost();
        //Then
        Assert.assertEquals("User prefers Snapchat as a social medium", aniasSocialPublisherIndividualPreferences);
        Assert.assertEquals("User prefers Facebook as a social medium", magdaSocialPublisherIndividualPreferences);

    }
}
