package com.star.entity;

public class Seat {
    private int id;
    private String seatNum;
    private int owner;
    private int speach;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getSpeach() {
        return speach;
    }

    public void setSpeach(int speach) {
        this.speach = speach;
    }
}
