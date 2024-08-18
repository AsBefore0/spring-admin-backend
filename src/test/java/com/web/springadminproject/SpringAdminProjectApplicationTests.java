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
//        PageBean b = userService.page(2,4,null,null,null);
//        System.out.println(b.getRows());
    }
}
