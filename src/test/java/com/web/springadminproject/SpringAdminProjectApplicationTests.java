package com.web.springadminproject;

import com.web.pojo.PageBean;
import com.web.pojo.User;
import com.web.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringAdminProjectApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        List<Integer> ids = List.of(2,3);
        userService.delete(ids);
    }
}
