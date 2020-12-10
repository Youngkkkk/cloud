package com.ykm.springcloud.controller;

import com.ykm.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ykm
 * @date 2020/12/10 2:55 下午
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
