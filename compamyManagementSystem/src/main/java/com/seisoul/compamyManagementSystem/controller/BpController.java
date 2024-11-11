package com.seisoul.compamyManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BpController {
	//显示bp登录页面
	@GetMapping("/bp/register")
	public String register(Model model){
	        return "bpregister";
	    }
	}


