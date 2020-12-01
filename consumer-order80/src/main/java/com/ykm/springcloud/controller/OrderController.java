package com.ykm.springcloud.controller;

import com.ykm.springcloud.dto.PaymentDTO;
import com.ykm.springcloud.entity.Payment;
import com.ykm.springcloud.lb.LoadBalancer;
import io.swagger.annotations.Api;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author ykm
 * @date 2020/11/26 4:11 下午
 */
@Api(tags = "支付控制器")
@RestController
@RequestMapping("/order")
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("consumer/payment/create")
    public boolean create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, boolean.class);
    }

    @GetMapping("consumer/payment/get/{id}")
    public PaymentDTO getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, PaymentDTO.class);
    }

    @GetMapping("/consumer/payment/lb/{id}")
    public PaymentDTO getPaymentLB(@PathVariable String id) {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("cloud-payment-service");
        if (CollectionUtils.isEmpty(instanceList)) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instance(instanceList);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/get/" + id, PaymentDTO.class);
    }

}
