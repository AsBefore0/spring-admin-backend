package com.web.controller;

import com.web.pojo.Admin;
import com.web.pojo.Result;
import com.web.service.AdminService;
import com.web.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {
    private final AdminService adminService;
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        log.info("管理员登录: {}", admin);
        Admin e = adminService.login(admin);
        //登录成功,生成令牌,下发令牌
        if (e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("phone", e.getPhone());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(claims); //jwt包含了当前登录的管理员信息
            log.info("令牌生成成功");
            return Result.success(jwt);
        }
        //登录失败, 返回错误信息
        return Result.error("用户名或密码错误");
    }
}
