package com.ykm.springcloud.controller;

import com.ykm.springcloud.dto.PaymentDTO;
import com.ykm.springcloud.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ykm
 * @date 2020/11/26 4:11 下午
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/consul")
    public Object getPayment() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }

}
