package com.jason.service;

import com.jason.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by jason on 15/9/2.
 */
public interface UserService {

    int insert(User user);
    List<User> select(Map<String,String> map);

}
