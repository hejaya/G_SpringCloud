package com.sc.webs.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sc.common.response.ResponseResult;
import com.sc.webs.dao.UserMapper;
import com.sc.webs.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 20:44
 **/
@Slf4j
@Service
@Transactional
@RabbitListener(queues = "gts")
public class UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //@RabbitHandler
    public void showMsg(String msg){
        log.info("收到消息---->" + msg);
    }

    public ResponseResult getAllUsers() {

        User user = new User();
        user.setId(1);
        user.setUname("111111111");
        User user1 = new User();
        user1.setId(2);
        user.setUname("222222222");
        userMapper.updateById(user);
        int a =  1/0;

        userMapper.updateById(user1);
        /*stringRedisTemplate.opsForValue().set("15236984568","824367",5, TimeUnit.MINUTES);
        rabbitTemplate.convertAndSend("gts","15269895632");*/
        return new ResponseResult(true, 200, "查询成功", userMapper.selectList(null));
    }

    public ResponseResult getAllUsersByPage(Integer page, Integer rows) {
        Page<User> pageQuery = new Page<>(page, rows);
        IPage<User> userPages = userMapper.selectPage(pageQuery, null);
        return new ResponseResult(true, 200, "查询成功",
                new com.sc.common.utils.Page<User>(userPages.getRecords(),//数据集合
                        page,//当前页数
                        10,//userPages.getSize()每页数量
                        userPages.getTotal()));
    }
}
