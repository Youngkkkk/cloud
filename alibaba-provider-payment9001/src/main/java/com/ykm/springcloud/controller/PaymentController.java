package com.ykm.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ykm
 * @date 2020/12/12 9:18 下午
 */
@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/nacos/{id}")
    public String getServerPort(@PathVariable("id") Integer id) {
        return "serverPort:" + serverPort + "\t,id:" + id;
    }
}
