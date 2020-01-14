package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author du.dawei
 * @title JwtUtil
 * @projectName demo
 * @date 1/14/2020 10:23 AM
 * @description : DOTO
 **/
@Component
public class JwtUtil {
	
	public static String ISS = "demo_project";
	
	/**
	 * iss: jwt签发者
	 * sub: jwt所面向的用户
	 * aud: 接收jwt的一方
	 * exp: jwt的过期时间，这个过期时间必须要大于签发时间
	 * nbf: 定义在什么时间之前，该jwt都是不可用的.
	 * iat: jwt的签发时间
	 * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
	 */
	public static String generatorToken(User user) {
		String token = JWT.create()
				.withIssuer( JwtUtil.ISS )
				.withSubject( user.getId() )
				.withIssuedAt( new Date() )
				.sign( Algorithm.HMAC256(user.getPassword()));
		return token;
	}
}
