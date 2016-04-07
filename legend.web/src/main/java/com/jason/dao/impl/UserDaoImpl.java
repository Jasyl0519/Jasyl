package com.jason.dao.impl;

import com.jason.dao.UserDao;
import com.jason.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by jason on 15/9/2.
 */
@Repository
public class UserDaoImpl implements UserDao{

    public Integer insert(User user) {
        System.out.println("DAO INSERT SUCCESS");
        return 1;
    }

    public List<User> select(Map<String, String> map) {


        return null;
    }
}
