package com.ybl.net.gateway;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//import com.netflix.hystrix.exception.HystrixRuntimeException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
/*@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication*/
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
