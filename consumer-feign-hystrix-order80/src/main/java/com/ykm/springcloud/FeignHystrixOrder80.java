package com.ykm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ykm
 * @date 2020/12/5 9:12 下午
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignHystrixOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrder80.class, args);
    }

}
