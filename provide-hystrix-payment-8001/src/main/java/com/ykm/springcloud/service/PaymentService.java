package com.ykm.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.concurrent.TimeUnit;

/**
 * @author ykm
 * @date 2020/12/3 10:53 下午
 */
@Service
@Slf4j
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_OK, id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "8000")
    })
    public String paymentInfo_Timeout(Integer id) {
        log.info("8001");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_Timeout, id:" + id;
    }

    private String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "8001：paymentInfo_TimeoutHandler, id:" + id + "服务器忙或运行错误！";
    }

    /**
     * 服务熔断
     * <p> open->half-open->close/open->... </p>
     *
     * @param id
     * @return
     * @see com.netflix.hystrix.HystrixCommandProperties
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),     // 开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),   // 10秒内熔断开启所需请求次数为20（默认）
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),   // 错误阈值百分比（默认50 %），
            // 也就是说：10秒内所接收的20+次数内存在60%比例的错误请求，则开启熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")  // 窗口期（默认5s,开启到半开）,
            // 也就是说，熔断器开启的10s内，全部请求走降级方法，窗口期之后，统计部分请求若成存在成功则进入关闭状态，否则重新进入开启状态

    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能小于0");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    private String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能为负数，请稍后重试，id:" + id;
    }

}
