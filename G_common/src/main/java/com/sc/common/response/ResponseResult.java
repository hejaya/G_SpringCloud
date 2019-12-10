package com.sc.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/30 8:09
 **/
@ToString
@Setter
@Getter
@AllArgsConstructor
public class ResponseResult implements Serializable {

    private boolean success;
    private Integer code;
    private String message;
    private Object data;
}
