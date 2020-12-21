package com.ykm.springcloud.service;

import com.ykm.springcloud.dto.PaymentDTO;
import org.springframework.stereotype.Component;

/**
 * @author ykm
 * @date 2020/12/19 10:36 下午
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public PaymentDTO paymentSQL(Long id) {
        return new PaymentDTO(404L, "服务降级返回,----PaymentFallbackService", null);
    }
}
