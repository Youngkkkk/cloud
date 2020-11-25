package com.ykm.springcloud.bs.pay.controller;


import com.ykm.springcloud.bs.pay.entity.Payment;
import com.ykm.springcloud.bs.pay.service.IPaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ykm
 * @since 2020-11-25
 */
@Api(tags = "支付控制器")
@RestController
@RequestMapping("/pay/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final IPaymentService iPaymentService;

    @PostMapping("/save")
    @ApiOperation("新增")
    public Object save(@RequestBody Payment payment) {
        return iPaymentService.save(payment);
    }

    @PostMapping("removeById")
    @ApiOperation("根据id删除")
    public Object removeById(Integer id) {
        return iPaymentService.removeById(id);
    }

}
