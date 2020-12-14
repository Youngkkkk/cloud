package com.ykm.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ykm
 * @date 2020/12/14 10:30 下午
 */
@RestController
public class FlowLimitController {

    @GetMapping("testA")
    public String testA(){
        return "testA";
    }

    @GetMapping("testB")
    public String testB(){
        return "testB";
    }

}
