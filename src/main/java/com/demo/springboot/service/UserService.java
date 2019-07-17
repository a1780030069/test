package com.demo.springboot.service;

import com.demo.springboot.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查看全部用户
     * @return
     */
    List<User> seleteAll();

    /**
     * 新增用户
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 更新用户
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 删除用户
     * @param uid
     * @return
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * 刷新token
     * @param token
     * @return
     */
    String refreshToken(String token);
}
