package com.zzz.mongodb.service.impl;

import com.zzz.mongodb.entry.User;
import com.zzz.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell_2 on 2016/8/30.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    MongoTemplate mongoTemplate;

    private static  String USER_COLLECTION="user";

    public int addUser(User user) {
        mongoTemplate.save(user,USER_COLLECTION);
        return 1;
    }

    public User findUserByName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        return mongoTemplate.findOne(query,User.class,USER_COLLECTION);
    }

    public List<User> list() {
        Query query = new Query();
        return mongoTemplate.find(query,User.class,USER_COLLECTION);
    }

    public void removeOne(Integer id) {
        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query(criteria);
        User user = mongoTemplate.findOne(query, User.class,USER_COLLECTION);
            if(query != null &&  user != null)
                mongoTemplate.remove(user);
    }
}
