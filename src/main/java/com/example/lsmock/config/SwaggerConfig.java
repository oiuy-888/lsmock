package com.example.lsmock.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()//build模式,返回一个建造者
                    .apis(RequestHandlerSelectors.any())//api的配置路径
                    .paths(Predicates.not(PathSelectors.regex("/error.*")))
                    .paths(PathSelectors.any())//扫描路径选择
                    .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("ls项目接口文档") //文档标题
                    .description("ls项目接口文档")//接口概述
                    .build();
        }
}
