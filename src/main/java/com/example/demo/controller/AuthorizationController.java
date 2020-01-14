package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author du.dawei
 * @title AuthorizationController
 * @projectName demo
 * @date 1/14/2020 10:58 AM
 * @description : DOTO
 **/
@RestController
public class AuthorizationController {
	@Autowired
	UserService userService;

	/**
	 * @author du.dawei
	 * @description 登录
	 * @date 2020-01-14 11:02
	 * @param user
	 * @return java.lang.Object
	 */
	@PostMapping("/login")
	public Object login(@RequestBody User user){
		JSONObject jsonObject=new JSONObject();
		String token = JwtUtil.generatorToken(user);
		jsonObject.put("token", token);
		jsonObject.put("user", user);
		return jsonObject;
	}

	@GetMapping("/getMessage")
	public String getMessage(){
		return "你已通过验证";
	}
}
