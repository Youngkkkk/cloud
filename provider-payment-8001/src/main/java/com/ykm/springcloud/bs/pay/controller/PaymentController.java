package com.ykm.springcloud.bs.pay.controller;


import com.ykm.springcloud.bs.pay.entity.Payment;
import com.ykm.springcloud.bs.pay.service.IPaymentService;
import com.ykm.springcloud.dto.PaymentDTO;
import com.ykm.springcloud.util.BeanHelperUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final IPaymentService iPaymentService;

    @PostMapping("create")
    @ApiOperation("新增")
    public boolean save(@RequestBody Payment payment) {
        return iPaymentService.save(payment);
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据id查询")
    public PaymentDTO get(@PathVariable("id") Long id) {
        Payment payment = iPaymentService.getById(id);
        return BeanHelperUtil.convert(payment, new PaymentDTO());
    }

    @PostMapping("removeById")
    @ApiOperation("根据id删除")
    public boolean removeById(Integer id) {
        return iPaymentService.removeById(id);
    }

}
