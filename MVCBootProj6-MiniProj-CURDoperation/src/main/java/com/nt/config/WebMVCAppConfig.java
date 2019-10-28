package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"com.nt.controller"})
//@PropertySource(value="classpath:com/nt/commons/validation.properties")
public class WebMVCAppConfig {
	
	
	

}
