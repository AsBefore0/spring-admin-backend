package com.web.mapper;

import com.web.pojo.User;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface UserMapper {

    // 用户信息分页条件查询
    List<User> list(@Param("username") String username,
                    @Param("gender") Short gender,
                    @Param("createdTime") LocalDate createdTime);


    // 批量删除
    int delete(List<Integer> ids);


    // 新增员工
    @Insert("insert into tb_user(username, password, gender, email, phone, created_time, updated_time) " +
            " values(#{username},#{password},#{gender},#{email},#{phone},#{createdTime},#{updatedTime})")
    void insert(User user);

    // 根据ID查询用户
    @Select("select * from tb_user where id = #{id}")
    User getById(Integer id);

    // 更新用户
    void update(User user);
}