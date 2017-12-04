package com.star.entity;

/**
 * 座位实体类.
 * 包含座位的信息:<br>
 *     id:座位记录的id<br>
 *     seatNum：座位编号<br>
 *     owner:用户 <br>
 *     speach:活动Id <br>
 */
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
