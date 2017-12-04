package com.star.entity;

/**
 * 用户实体.
 * 包含用户相关信息的实体类
 */
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