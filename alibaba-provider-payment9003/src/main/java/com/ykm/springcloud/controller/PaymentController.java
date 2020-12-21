package com.ykm.springcloud.controller;

import com.ykm.springcloud.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ykm
 * @date 2020/12/19 9:10 下午
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, PaymentDTO> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,new PaymentDTO(1L,"11111111111111", null));
        hashMap.put(2L,new PaymentDTO(2L,"22222222222222", null));
        hashMap.put(3L,new PaymentDTO(3L,"33333333333333", null));
    }

    @GetMapping("/paymentSQL/{id}")
    public PaymentDTO paymentSQL(@PathVariable("id") Long id) {
        PaymentDTO paymentDTO = hashMap.get(id);
        paymentDTO.setModel(serverPort);
        return paymentDTO;
    }

}
