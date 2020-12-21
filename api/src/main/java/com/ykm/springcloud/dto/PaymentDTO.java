package com.ykm.springcloud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ykm
 * @date 2020/11/26 5:43 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String serial;

    private T model;


}