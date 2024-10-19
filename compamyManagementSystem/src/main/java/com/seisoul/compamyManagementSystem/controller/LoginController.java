package com.seisoul.compamyManagementSystem.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    // 显示登录页面
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";  // 如果未认证，重定向到登录页面
        }
        String username = authentication.getName();  // 获取当前登录的用户名
        model.addAttribute("username", username);
        return "home";  // 返回 home 视图
    }
}
