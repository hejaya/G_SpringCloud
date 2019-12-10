package com.sc.dep.dao;

import com.sc.dep.pojo.Menu;

import java.util.List;

/**
  * @Author: Gthree
  * @Mood: Pumped Up
  * @Date: 2019/9/3 7:47
  **/
public interface MenuMapper {
    List<Menu> selectAllByPid(Integer pid);
}