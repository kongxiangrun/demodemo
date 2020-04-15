package com.example.demo;

import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableSwagger2Doc
@EnableFeignClients
public class DemoDemoApplication extends SpringBootServletInitializer implements ApplicationRunner {


	public static void main(String[] args) {
		SpringApplication.run(DemoDemoApplication.class, args);
	}

	@Value("${server.port:8080}")
	private Integer port;

	@Autowired
	private NacosAutoServiceRegistration registration;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(registration!=null && port!=null) {
			registration.setPort(port);
			registration.start();
		}
	}
}
