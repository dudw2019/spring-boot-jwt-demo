package com.example.demo.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author du.dawei
 * @title OAuthInterceptor
 * @projectName demo
 * @date 1/14/2020 9:58 AM
 * @description : DOTO
 **/
public class OAuthInterceptor implements HandlerInterceptor {
  @Autowired
  UserService userService;
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws RuntimeException {
	  String token = request.getHeader( "Authorization" )
			  .replace("Bearer","").trim();
	  if(null == token || token.isEmpty()){
		  throw new RuntimeException("require token!");
	  }
	  String issuer = JWT.decode( token ).getIssuer();
	  if( !JwtUtil.ISS.equals( issuer ) ) {
	  	throw new RuntimeException( "invalid token: Iss is invalid!" );
	  }
	  String userId = JWT.decode( token ).getSubject();
	  User user = userService.getById( userId );
	  JWTVerifier jwtVerifier = JWT.require( Algorithm.HMAC256( user.getPassword() ) ).build();
	  try {
	  	jwtVerifier.verify( token );
	  }catch ( JWTVerificationException e ) {
	  	throw new RuntimeException( "token verify failed" );
	  }
	  return true;
  }
}
