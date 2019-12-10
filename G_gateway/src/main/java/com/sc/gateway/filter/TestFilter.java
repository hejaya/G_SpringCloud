package com.sc.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 16:30
 **/

public class TestFilter extends ZuulFilter {
    @Override
    public String filterType() {//过滤器类型
        return "pre";//前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0;//优先级，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return false;//过滤器开关，true表示开启
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
