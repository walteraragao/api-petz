package br.com.petz.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.petz.endpoint"))
                .paths(PathSelectors.any())
                    .build()
                        .useDefaultResponseMessages(false)
                        .globalResponseMessage(RequestMethod.GET, getResponseMessagesGET())
                        .apiInfo(apiInfo());
    }

 

    private List<ResponseMessage> getResponseMessagesGET() {
        List<ResponseMessage> result = new ArrayList<>();
        result.add(new ResponseMessageBuilder().code(200).message("OK")
                .build());
        result.add(new ResponseMessageBuilder().code(500).message("Internal Server Error")
                .build());
        return result;
    }

 

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .description("Petz API").title("Petz API")
                .contact(new Contact("Walter Aragão", "", "walteracf@gmail.com"))
                .version("1.0.0")
                .build();
    }
}
