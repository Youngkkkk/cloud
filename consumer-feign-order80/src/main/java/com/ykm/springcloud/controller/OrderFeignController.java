package com.ykm.springcloud.controller;

import com.ykm.springcloud.dto.PaymentDTO;
import com.ykm.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ykm
 * @date 2020/12/1 8:37 下午
 */
@RestController
@RequestMapping("/order")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("consumer/payment/get/{id}")
    public PaymentDTO getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPayment(id);
    }

    @GetMapping("consumer/payment/feign/timeout")
    public String paymentTimeout(){
        return paymentFeignService.paymentTimeout();
    }

}
