package com.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.mapper.UserMapper;
import com.web.pojo.User;
import com.web.pojo.PageBean;
import com.web.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    
    @Override
    public PageBean page(Integer page, Integer pageSize,String username, Short gender, LocalDate createdTime) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);
        //2. 执行查询
        List<User> userList = userMapper.list(username, gender, createdTime);

        Page<User> p = (Page<User>) userList;

        //3. 封装PageBean对象
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public int delete(List<Integer> ids) {
        return userMapper.delete(ids);
    }

    @Override
    public void save(User user) {
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void update(User user) {
        user.setUpdatedTime(LocalDateTime.now());
        userMapper.update(user);
    }
}
