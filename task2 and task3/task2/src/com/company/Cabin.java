package com.company;

public class Cabin {
    protected Passenger guest;

    public Cabin(Passenger guest) {
        this.guest = guest;
    }

    public Passenger getGuest() {
        return guest;
    }

    public void setGuest(Passenger guest) {
        this.guest = guest;
    }
}
