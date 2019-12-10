package com.sc.webs.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/8/18 12:42
 **/
@Service
public class WebSService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsgToMq(){
        rabbitTemplate.convertAndSend("gts","aaaaaaaaaaaaaaaaa");
    }

}
