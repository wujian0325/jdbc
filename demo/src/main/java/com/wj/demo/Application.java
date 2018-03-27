package com.wj.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
