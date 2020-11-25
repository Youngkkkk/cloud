package com.ykm.springcloud.bs.pay.service.impl;

import com.ykm.springcloud.bs.pay.entity.Payment;
import com.ykm.springcloud.bs.pay.mapper.PaymentMapper;
import com.ykm.springcloud.bs.pay.service.IPaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ykm
 * @since 2020-11-25
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements IPaymentService {

}
