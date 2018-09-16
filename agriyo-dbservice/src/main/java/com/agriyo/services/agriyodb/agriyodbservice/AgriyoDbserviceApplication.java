package com.agriyo.services.agriyodb.agriyodbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@EnableEurekaClient
@SpringBootApplication
@EnableJpaRepositories(basePackages="com.agriyo.services.agriyodb.agriyodbservice")
@ComponentScan(basePackages="com.agriyo.services.agriyodb.agriyodbservice")
@Configuration
@EnableAutoConfiguration
public class AgriyoDbserviceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AgriyoDbserviceApplication.class, args);
	}

	 private static Class<AgriyoDbserviceApplication> applicationClass = AgriyoDbserviceApplication.class;
		

	   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }
	@Bean
	public FilterRegistrationBean corsFilter() { 
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	    bean.setOrder(0);
	    return bean;
	}
}
