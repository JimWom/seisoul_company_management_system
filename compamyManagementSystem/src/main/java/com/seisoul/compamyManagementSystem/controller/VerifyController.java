package com.seisoul.compamyManagementSystem.controller;

import com.seisoul.compamyManagementSystem.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VerifyController {

    private final UserDetailsService userDetailsService;

    public VerifyController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/verify")
    public Object verifyUser(@RequestBody User user, HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        if (user.getUserName() == null || user.getUserName().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty()) {
            response.put("success", false);
            response.put("message", "用户名和密码不能为空");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());

        if (userDetails != null && user.getPassword().equals("1234")) {
            // 创建 Authentication 对象并存储到 SecurityContextHolder 中
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // 假设我们验证用户成功，将用户信息放入会话中
            session.setAttribute("loggedInUser", user.getUserName());  // 将用户名存入会话
            // 重定向到 /home
            return new RedirectView("/home");
        } else {
            response.put("success", false);
            response.put("message", "用户名或密码不正确");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
}
