package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author du.dawei
 * @title User
 * @projectName demo
 * @date 1/14/2020 10:20 AM
 * @description : DOTO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String id;
	private String userName;
	private String password;
}
