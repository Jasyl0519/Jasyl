package com.dao;

import com.entity.UserVo;

/**
 * Created by jason on 16/4/18.
 */
public interface UserDao {

    UserVo select(Integer id);

}
