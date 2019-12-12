package com.sc.dep.service;

import com.sc.common.response.ResponseResult;
import com.sc.dep.dao.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
  * @Author: Gthree
  * @Mood: Pumped Up
  * @Date: 2019/9/3 7:47
  **/


@Service
@Transactional
public class MenuService{

    @Autowired
    private MenuMapper menuMapper;

    public ResponseResult getAllMenus(Integer pid){
        return new ResponseResult(true,200,"查询成功",menuMapper.selectAllByPid(pid));
    }
}
