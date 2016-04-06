package com.jason.service.impl;

import com.jason.dao.UserDao;
import com.jason.model.User;
import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by jason on 15/9/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public int insert(User user) {
        Integer integer = userDao.insert(user);
        System.out.print("service insert success ");

        return 0;
    }

    public List<User> select(Map<String, String> map) {

        List<User> list = userDao.select(map);

        System.out.println(list);
        return null;


    }


}

