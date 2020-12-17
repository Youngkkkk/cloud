package com.ykm.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author ykm
 * @date 2020/12/17 10:57 下午
 */
public class CustomerBlockHandler {

    public static String handlerException(BlockException exception) {
        return "自定义全局降级处理---1";
    }

    public static String handlerException2(BlockException exception) {
        return "自定义全局降级处理---2";
    }

}
