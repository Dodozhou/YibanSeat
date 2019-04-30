package com.star.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动实体.
 * 包含活动相关信息的实体类
 */
public class Speach implements Serializable {
    private int id=-1;
    private String title;
    private String description;
    private String place;
    private Date time;
    private static final long serialVersionUID = 2663283546876721484L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
