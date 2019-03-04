package com.dongzhi.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName:     Application.java
 * @Description:   SpringBoot启动类，打包war需要新加@ServletComponentScan注解, 继承SpringBootServletInitializer
 * @author         dongzhi
 * @version        V1.0  
 * @Date           2019年2月16日 下午7:25:11
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
