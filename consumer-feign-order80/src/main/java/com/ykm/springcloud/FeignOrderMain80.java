package com.ykm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ykm
 * @date 2020/12/1 8:27 下午
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain80.class, args);
    }

}
