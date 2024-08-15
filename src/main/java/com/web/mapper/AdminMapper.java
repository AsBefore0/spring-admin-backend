package com.web.mapper;

import com.web.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    // 根据用户名和密码查询管理员
    @Select("select * from tb_admin where username = #{username} and password = #{password}")
    Admin getByUsernameAndPassword(Admin admin);
}
