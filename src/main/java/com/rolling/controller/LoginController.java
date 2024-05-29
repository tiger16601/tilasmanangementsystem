package com.rolling.controller;

import com.rolling.pojo.Emp;
import com.rolling.pojo.Result;
import com.rolling.service.EmpService;
import com.rolling.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;

    @PostMapping
    public Result loginByNaP(@RequestBody Emp emp) {
        log.info("根据id登录:{}", emp);
        Emp e = empService.login(emp);
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            System.out.println("未生成令牌");
            String jwt = JwtUtils.generateJwt(claims);
            System.out.println("生成令牌成功");
            return Result.success(jwt);
        }
        return Result.error("用户名或者密码错误");
    }
}
