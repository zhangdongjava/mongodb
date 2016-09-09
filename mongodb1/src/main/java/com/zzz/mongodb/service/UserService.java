package com.zzz.mongodb.service;

import com.zzz.mongodb.entry.User;

import java.util.List;

/**
 * Created by dell_2 on 2016/8/30.
 */
public interface UserService {

    int addUser(User user);

    User findUserByName(String userName);

    List<User> list();

    void removeOne(Integer id);
}
