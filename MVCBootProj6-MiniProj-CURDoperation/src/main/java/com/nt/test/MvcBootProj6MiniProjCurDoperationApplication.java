package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

@SpringBootApplication
@Import({RootAppConfig.class,WebMVCAppConfig.class})
public class MvcBootProj6MiniProjCurDoperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcBootProj6MiniProjCurDoperationApplication.class, args);
	}

}
