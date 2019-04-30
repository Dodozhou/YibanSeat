package com.star.entity;

import java.io.Serializable;

/**
 * 座位实体类.
 * 包含座位的信息:<br>
 *     id:座位记录的id<br>
 *     seatNum：座位编号<br>
 *     owner:用户 <br>
 *     speach:活动Id <br>
 */
public class Seat implements Serializable {
    private String seatNum; //座位编号
    private int owner; //座位预定者
    private int speach; //讲座ID
    private boolean signed; //是否签到
    private static final long serialVersionUID = 2633583546876721484L;

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

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }
}
