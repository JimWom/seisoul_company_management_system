package com.seisoul.compamyManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccoutController {
	@GetMapping("/user/profile")
	public String userprofile(Model model) {
		return "userprofile";

	}
}
