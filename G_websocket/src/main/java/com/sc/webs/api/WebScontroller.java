package com.sc.webs.api;

import com.sc.webs.service.WebSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/8/18 12:18
 **/
@Controller
public class WebScontroller {

    @Autowired
    WebSService sService;

    @Autowired
    public SimpMessagingTemplate template;

    @RequestMapping("ws/send")
    @ResponseBody
    public void senMsg() {
        for(int i =1;i<=5;i++) {
            //广播使用convertAndSend方法，第一个参数为目的地，和js中订阅的目的地要一致
            template.convertAndSend("/topic/getResponse", "曹尼玛"+i);
        }
    }

    @MessageMapping("/hello")
    @SendTo("/topic/cnm")
    public String reviceMsg(String reMsg){
        System.out.println("reMsg = " + reMsg);
        return reMsg;
    }

}
