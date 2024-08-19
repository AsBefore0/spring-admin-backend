package com.web.controller;

import com.web.pojo.User;
import com.web.pojo.PageBean;
import com.web.pojo.Result;
import com.web.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// 用户管理Controller
@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "用户管理", description = "用户管理API")
public class UserController {

    private final UserService userService;

    @Operation(summary = "分页查询用户信息")
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "6") Integer pageSize,
                       String username, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createdTime){
        //调用service分页查询
        PageBean pageBean = userService.page(page,pageSize,username,gender,createdTime);
        return Result.success(pageBean);
    }

    @Operation(summary = "批量删除用户信息")
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作, ids:{}",ids);
        int nums = userService.delete(ids);
        return Result.success();
    }

    @Operation(summary = "新增用户信息")
    @PostMapping
    public Result save(@RequestBody User user){
        log.info("新增员工, emp: {}", user);
        userService.save(user);
        return Result.success();
    }

    @Operation(summary = "根据ID查询用户信息")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询员工信息, id: {}",id);
        User user = userService.getById(id);
        return Result.success(user);
    }

    @Operation(summary = "更新用户信息")
    @PutMapping
    public Result update(@RequestBody User user){
        log.info("更新员工信息 : {}", user);
        userService.update(user);
        return Result.success();
    }
}






