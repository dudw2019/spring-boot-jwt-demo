package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author du.dawei
 * @title UserService
 * @projectName demo
 * @date 1/14/2020 10:44 AM
 * @description : DOTO
 **/
@Service
public class UserService {
	
	public User getById(String Id) {
		return new User( Id,"test","test" );
	}
}
