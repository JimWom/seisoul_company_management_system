package com.seisoul.compamyManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/verify")
    public String verify(){
        // TODO: 2024/10/06  ifで情報をチェック、OKの場合はインボイス画面に移動、じゃないと画面でエラーメッセージをする。
        return "invoices";
    }
}
