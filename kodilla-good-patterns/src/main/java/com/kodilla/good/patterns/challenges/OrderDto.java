package com.kodilla.good.patterns.challenges;

public class OrderDto {

    public String userLogin;
    public boolean isOrdered;

    public OrderDto(String userLogin, final boolean isOrdered) {
        this.userLogin = userLogin;
        this.isOrdered = isOrdered;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
