package com.ykm.springcloud.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ykm
 * @date 2020/11/26 5:43 下午
 */
@Data
public class PaymentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String serial;


}