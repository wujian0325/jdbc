package com.wj.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author  吴健
 * @created 2018-03-12
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.wj.demo")
public class Application {
	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}
