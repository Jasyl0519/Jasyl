package com.jason.dao;

import com.jason.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by jason on 15/9/2.
 */
public interface UserDao {

    Integer insert(User user);
    List<User> select(Map<String,String> map);
}
