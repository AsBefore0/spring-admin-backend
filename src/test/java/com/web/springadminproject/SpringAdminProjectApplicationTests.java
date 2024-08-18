package com.web.springadminproject;

import com.web.pojo.PageBean;
import com.web.pojo.User;
import com.web.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringAdminProjectApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void contextLoads() {
        userService.page(1,1,null,null,null);

    }
}
