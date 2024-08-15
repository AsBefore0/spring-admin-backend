package com.web.mapper;

import com.web.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface UserMapper {

    // 分页查询,获取列表数据
    @Select("select * from tb_user limit #{start},#{pageSize}")
    public List<User> page(Integer start, Integer pageSize);

    // 用户信息查询
    @Select("select * from tb_user")
    public List<User> list(String name, Short gender, LocalDate begin, LocalDate end);


    // 批量删除
    void delete(List<Integer> ids);


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