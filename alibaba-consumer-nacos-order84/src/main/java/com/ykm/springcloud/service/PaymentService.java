package com.ykm.springcloud.service;

import com.ykm.springcloud.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ykm
 * @date 2020/12/19 10:33 下午
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    PaymentDTO paymentSQL(@PathVariable("id") Long id);

}
