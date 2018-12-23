package com.signin.signin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.signin.*"})
@SpringBootApplication
@MapperScan("com.signin.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class SigninApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigninApplication.class, args);
	}

}

