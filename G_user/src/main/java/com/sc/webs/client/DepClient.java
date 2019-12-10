package com.sc.webs.client;

import com.sc.common.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 16:13
 **/
@FeignClient(value = "g-dep",fallback = DepClientImpl.class)
public interface DepClient {

    @RequestMapping(value = "dep/deps",method = RequestMethod.GET)
    ResponseResult getAllDeps();
}
