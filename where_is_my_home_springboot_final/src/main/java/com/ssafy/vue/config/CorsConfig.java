package com.ssafy.vue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// vs code live server를 사용하면 cors 오류가 뜸.
// 두 개의 서버가 돌아가서 생기는 오류!
// 두 가지 방법이 있는데, 이렇게 CorsConfig를 만들어주거나
// 모든 컨트롤러에 @CrossOrigin 어노테이션을 추가하면 된다.
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://127.0.0.1:5500", "http://127.0.0.1:9000", "http://127.0.0.1:8080")
		.allowedMethods("*")
		.allowCredentials(true);
	}

}
