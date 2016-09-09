package com.zzz.mongodb.entry;

import java.io.Serializable;

/**
 * Created by dell_2 on 2016/8/30.
 */
public class User implements Serializable {

    private  Integer id;
    private  String userName;
    private  String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
