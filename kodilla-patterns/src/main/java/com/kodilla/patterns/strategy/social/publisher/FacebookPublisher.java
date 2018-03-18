package com.kodilla.patterns.strategy.social.publisher;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher {

    @Override
    public String share(){
        return "User prefers Facebook as a social medium";
    }
}
