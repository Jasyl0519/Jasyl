package com.service.impl;

import com.dao.UserDao;
import com.entity.UserVo;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jason on 16/4/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public UserVo getUser(int id) {

        System.out.println(id);

        UserVo userVo = userDao.select(1);
        return userVo;
    }
}
