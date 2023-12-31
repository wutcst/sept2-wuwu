package com.wuwu.worldofzuulwuwu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ServletComponentScan
public class WorldOfZuulWuwuApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldOfZuulWuwuApplication.class, args);
	}

}
