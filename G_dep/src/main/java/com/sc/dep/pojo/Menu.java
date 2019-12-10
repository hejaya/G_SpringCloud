package com.sc.dep.pojo;

import lombok.*;

import java.util.List;

/**
  * @Author: Gthree
  * @Mood: Pumped Up
  * @Date: 2019/9/3 7:47
  **/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Integer id;
    private String name;
    private Integer pid;
    private List<Menu> menus;
}