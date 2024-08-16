package com.web.controller;

import com.web.pojo.User;
import com.web.pojo.PageBean;
import com.web.pojo.Result;
import com.web.service.UserService;
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
public class UserController {

    private final UserService userService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询, 参数: {},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = userService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作, ids:{}",ids);
        userService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody User user){
        log.info("新增员工, emp: {}", user);
        userService.save(user);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询员工信息, id: {}",id);
        User user = userService.getById(id);
        return Result.success(user);
    }

    @PutMapping
    public Result update(@RequestBody User user){
        log.info("更新员工信息 : {}", user);
        userService.update(user);
        return Result.success();
    }
}






