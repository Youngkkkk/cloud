package com.ykm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ykm
 * @date 2020/12/12 9:15 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9003.class, args);
    }
}
