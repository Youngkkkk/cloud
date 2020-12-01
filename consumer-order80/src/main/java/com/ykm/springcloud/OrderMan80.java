package com.ykm.springcloud;

import com.ykm.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author ykm
 * @date 2020/11/26 4:09 下午
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "cloud-payment-service", configuration = MySelfRule.class)
public class OrderMan80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMan80.class, args);
    }

}
