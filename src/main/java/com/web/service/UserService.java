package com.web.service;

import com.web.pojo.User;
import com.web.pojo.PageBean;
import java.time.LocalDate;
import java.util.List;

// 用户管理
public interface UserService {
    // 分页查询
    PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end);
    // 批量删除
    void delete(List<Integer> ids);
    // 新增用户
    void save(User user);
    // 根据id查询用户
    User getById(Integer id);
    // 更新用户
    void update(User user);
}
