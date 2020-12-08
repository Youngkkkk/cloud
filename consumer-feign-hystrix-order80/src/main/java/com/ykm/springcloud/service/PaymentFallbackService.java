package com.ykm.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author ykm
 * @date 2020/12/5 11:09 下午
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK, 系统繁忙";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "paymentInfo_Timeout 系统繁忙";
    }
}
