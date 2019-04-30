package com.star.entity;

import java.io.Serializable;

/**
 * 用户实体.
 * 包含用户相关信息的实体类
 */
public class User implements Serializable {
    private int id;
    private String name;
    private String yibanId;
    private static final long serialVersionUID = 2933283546876721484L;

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