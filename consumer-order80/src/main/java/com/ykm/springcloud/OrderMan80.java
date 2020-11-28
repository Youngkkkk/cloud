package com.ykm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ykm
 * @date 2020/11/26 4:09 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMan80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMan80.class, args);
    }

}
