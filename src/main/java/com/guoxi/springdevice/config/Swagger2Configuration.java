package com.guoxi.springdevice.config;


import com.guoxi.springdevice.constant.RequestParams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger2配置
 *
 * @author guoxi@tg-hd.com
 * @since 2022/6/9 10:11
 */
@EnableSwagger2
@Configuration
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> params = new ArrayList<Parameter>();
        tokenPar.name(RequestParams.AUTHENTICATION.getCode()).description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        params.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.guoxi.springdevice.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(params)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot整合Swagger2 构建RESTful API")
                //创建人
                .contact(new Contact("guoxi", "http://localhost:8080", "guoxi_789@126.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}