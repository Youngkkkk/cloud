package com.ykm.springcloud.service;

import com.ykm.springcloud.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ykm
 * @date 2020/12/1 8:33 下午
 */
@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("payment/get/{id}")
    PaymentDTO getPayment(@PathVariable("id") Long id);

}
