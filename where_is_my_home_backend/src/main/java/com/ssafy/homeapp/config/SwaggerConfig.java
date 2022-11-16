package com.ssafy.homeapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        final ApiInfo apiInfo = new ApiInfoBuilder()
                .title("구해줘 홈즈 API 명세서")
                .description("<h3>구해줘 홈즈 웹의 RestApi에 대한 문서를 제공한다.</h3>")
                .contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com"))
                .license("MIT License")
                .version("1.0")
                .build();

        return new Docket(DocumentationType.OAS_30)        // 
                .apiInfo(apiInfo)                             // 문서에 대한 정보를 설정한다.
                .select()                                    // ApiSelectorBuilder를 반환하며 상세한 설정 처리
                .apis(RequestHandlerSelectors.basePackage("com.ssafy.homeapp.controller"))// 대상으로하는 api 설정
                .paths(PathSelectors.ant("/**"))    // controller에서 swagger를 지정할 대상 path 설정
                .build();                                    // Docket 객체 생성            
    }
}
