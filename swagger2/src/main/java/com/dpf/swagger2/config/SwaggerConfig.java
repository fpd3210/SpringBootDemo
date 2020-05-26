package com.dpf.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dpf
 * @create 2020-05-26 17:35
 * @email 446933040@qq.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createResApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dpf.swagger2.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("项目名称")
                        .description("项目描述详细信息。。。。")
                        .version("1.0")
                        .contact(new Contact("aaaa","blog.csdn.net","123@qq.com"))
                        .license("The Apache License")
                        .licenseUrl("http://www.baidu.com")
                        .build()
                );


    }
}
