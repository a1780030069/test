package com.demo.springboot.service.Impl;

import com.demo.springboot.entity.User;
import com.demo.springboot.mapper.UserMapper;
import com.demo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeriviceIpml implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> seleteAll() {
        return userMapper.selectAll();
    }

    @Override
    public int insert(User record) {
        System.out.println(record);
        return userMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public String refreshToken(String token) {
        return null;
    }
}
