package com.bvarba.appdirect.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@RequestMapping("/")
	public String home() {
		return "<h2>Welcome to Boris Varbanov's AppDirect Integration Chanllenge! :D</h2>";
	}
}
