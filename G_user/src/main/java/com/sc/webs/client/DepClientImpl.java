package com.sc.webs.client;

import com.sc.common.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 16:24
 **/
@Slf4j
@Component
public class DepClientImpl implements DepClient{
    @Override
    public ResponseResult getAllDeps() {
        return new ResponseResult(false,500,"服务器内部错误，交给熔断处理",null);
    }
}
