package com.ykm.springcloud.bs.pay.controller;


import com.ykm.springcloud.bs.pay.entity.Payment;
import com.ykm.springcloud.bs.pay.service.IPaymentService;
import com.ykm.springcloud.dto.PaymentDTO;
import com.ykm.springcloud.util.BeanHelperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ykm
 * @since 2020-11-25
 */
@Slf4j
@Api(tags = "支付控制器")
@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final IPaymentService iPaymentService;
    private final DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("create")
    @ApiOperation("新增")
    public Object save(@RequestBody Payment payment) {
        return iPaymentService.save(payment) + ":" + serverPort;
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据id查询")
    public PaymentDTO get(@PathVariable("id") Long id) {
        Payment payment = iPaymentService.getById(id);
        log.info("serverPort:{}", serverPort);
        PaymentDTO paymentDTO = BeanHelperUtil.convert(payment, new PaymentDTO());
        paymentDTO.setModel(serverPort);
        return paymentDTO;
    }

    @PostMapping("removeById")
    @ApiOperation("根据id删除")
    public boolean removeById(Integer id) {
        return iPaymentService.removeById(id);
    }

    @GetMapping("payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(element -> log.info("element:{}", element));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(element -> log.info("element:{}", element));
        return this.discoveryClient;
    }

}
