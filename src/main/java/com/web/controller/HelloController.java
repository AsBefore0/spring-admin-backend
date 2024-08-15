package com.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求处理类
@Tag(name = "用户接口")
@RestController
public class HelloController   {
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
