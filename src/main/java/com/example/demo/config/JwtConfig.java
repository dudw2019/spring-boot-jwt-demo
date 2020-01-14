package com.example.demo.config;

import com.example.demo.filter.OAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author du.dawei
 * @title JwtConfig
 * @projectName demo
 * @date 1/14/2020 9:51 AM
 * @description : DOTO
 **/
@Configuration
public class JwtConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor( oAuthInterceptor() )
				.excludePathPatterns( "/login" )
				.addPathPatterns( "/**" );
	}

	@Bean
	public OAuthInterceptor oAuthInterceptor() {
        return new OAuthInterceptor();
	}
}
