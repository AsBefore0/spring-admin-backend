package com.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.web.mapper.UserMapper;
import com.web.pojo.User;
import com.web.pojo.PageBean;
import com.web.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    
    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<User> userList = userMapper.list(name, gender, begin, end);
        Page<User> p = (Page<User>) userList;

        //3. 封装PageBean对象
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        userMapper.delete(ids);
    }

    @Override
    public void save(User user) {
        user.setCreatedTime(Timestamp.from(Instant.now()));
        user.setUpdatedTime(Timestamp.from(Instant.now()));
        userMapper.insert(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void update(User user) {
        user.setUpdatedTime(Timestamp.from(Instant.now()));
        userMapper.update(user);
    }
}
