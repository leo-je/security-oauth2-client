package cn.je.oauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping(value = { "/index", "/" })
	public Object index(Authentication authentication) {
		return authentication;
	}

}
