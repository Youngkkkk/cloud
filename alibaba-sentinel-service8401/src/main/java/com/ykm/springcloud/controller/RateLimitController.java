package com.ykm.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ykm.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ykm
 * @date 2020/12/17 10:44 下午
 */
@RestController
public class RateLimitController {

    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public String byResource() {
        return "200";
    }

    public String handleException(BlockException exception){
        return "500";
    }

    @GetMapping("rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public String customerBlockHandler() {
        return "200--customerBlockHandler";
    }

}
