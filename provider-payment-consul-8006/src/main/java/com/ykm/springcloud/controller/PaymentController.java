package com.ykm.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ykm
 * @date 2020/11/29 3:16 下午
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("consul")
    public String paymentConsul() {
        return "serverPort:" + serverPort + "; uuid:" + UUID.randomUUID().toString();
    }

}
