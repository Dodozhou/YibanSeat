package com.star.entity;

public class User {
    private int id;
    private String name;
    private String yibanId;

    public User(String name, String yibanId) {
        this.name = name;
        this.yibanId = yibanId;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYibanId() {
        return yibanId;
    }

    public void setYibanId(String yibanId) {
        this.yibanId = yibanId;
    }
}