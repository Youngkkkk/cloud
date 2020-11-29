package com.ykm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ykm
 * @date 2020/11/26 4:09 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMan80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMan80.class, args);
    }

}
