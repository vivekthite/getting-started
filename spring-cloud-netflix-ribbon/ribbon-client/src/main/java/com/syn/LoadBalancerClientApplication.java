package com.syn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoadBalancerClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerClientApplication.class, args);
	}
}
