package com.ykm.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ykm.springcloud.dto.PaymentDTO;
import com.ykm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ykm
 * @date 2020/12/19 9:31 下午
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate restTemplate;

    /**
     * 若blockHandler和fallback都进行了配置，则被限流降级而抛出BlockException时则只会进入blockHandler进行处理
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback", fallback = "handlerFallback")
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public PaymentDTO fallback(@PathVariable("id") Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        }
        PaymentDTO paymentDTO = restTemplate.getForObject(serviceUrl + "/paymentSQL/" + id, PaymentDTO.class);
        if (paymentDTO.getSerial() == null) {
            throw new NullPointerException("空指针异常，该id没有对应记录");
        }
        return paymentDTO;
    }

    public PaymentDTO handlerFallback(Long id, Throwable e) {
        PaymentDTO paymentDTO = new PaymentDTO(id, "null", e.getMessage());
        return paymentDTO;
    }

    public PaymentDTO blockHandler(Long id, BlockException e) {
        PaymentDTO paymentDTO = new PaymentDTO(id, "sentinel限流拉:", e.getMessage());
        return paymentDTO;
    }

    //==========feign============

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    PaymentDTO paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }


}
