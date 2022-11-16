package com.ssafy.homeapp.config;

import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.homeapp.listener.AppInitListener;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean // 해당 함수의 이름으로, 함수의 return 객체가 bean으로 등록됨
	public ServletListenerRegistrationBean<ServletContextListener> appInitListener() {
		ServletListenerRegistrationBean<ServletContextListener> srb 
				= new ServletListenerRegistrationBean<>();
		srb.setListener(new AppInitListener());
		return srb;
	}
	
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/user/login_form.do").setViewName("user/login");
//		registry.addViewController("/dept/register_form.do").setViewName("dept/register_form");
//		registry.addViewController("/emp/register_form.do").setViewName("emp/register_form");
//	}
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new LoginCheckInterceptor()).addPathPatterns("/dept/**");
//	}
}
