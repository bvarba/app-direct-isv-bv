package com.bvarba.appdirect.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	@RequestMapping("/")
	public String home() {
		return "<h2>Welcome to Boris Varbanov's AppDirect Integration Challenge! :D</h2><br />"+
					"This is a landing page and to show project is deployed. It will also serve later for OpenId login. But not yet.</b >"
					+ "For more project info, refer to <a href=\"https://github.com/bvarba/app-direct-isv-bv\">My GitHub repo</a>. Thanks!";
	}

	@RequestMapping("/login")
	public String login(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "login";
	}
}
