package com.play.bob.userinfo.bean;

import java.util.UUID;

/**
 * @author baobo.peng
 */
public class User {
    private String id;
    private String name;
    private String nickName;
    private long birth;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    private City city;

    public User(String name, String nickName, long birth) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.nickName = nickName;
        this.birth = birth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public long getBirth() {
        return birth;
    }

    public void setBirth(long birth) {
        this.birth = birth;
    }
}
