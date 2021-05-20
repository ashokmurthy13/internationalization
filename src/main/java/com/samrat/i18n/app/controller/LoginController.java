package com.samrat.i18n.app.controller;

import com.samrat.i18n.app.service.LoginService;
import com.samrat.i18n.app.validation.ValidateRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/v1/user")
public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource
    private ValidateRequest validateRequest;

    @GetMapping("/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password) {
        loginService.checkUserLanguage(userName);
        validateRequest.validate(userName);
        return loginService.checkUserPermission(userName);
    }
}
