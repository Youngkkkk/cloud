package com.ykm.springcloud.service;

import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ykm
 * @date 2020/12/3 10:53 下午
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK, id:" + id;
    }

    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_Timeout, id:" + id;
    }

}
