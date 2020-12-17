package com.ykm.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ykm
 * @date 2020/12/14 10:30 下午
 */
@RestController
public class FlowLimitController {

    @GetMapping("testA")
    public String testA() {
        return "testA";
    }

    @GetMapping("testB")
    public String testB() {
        return "testB";
    }

    /**
     * 热点参数限流
     * 注解@SentinelResource 的value值只要保证唯一就行，不一定要和注解@RequestMapping的value值一样，
     * 对应的sentinel界面的资源名，处理的是Sentinel控制台配置的违规情况，有blockHandler方法配置的兜底处理
     * blockHandler 需要指定降级方法，否则默认就会报错到前台
     *
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "deal_testHotkey")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "testHotkey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException exception) {
        // sentinel系统默认提示：
        return "-----deal_testHotkey";
    }

}
