package com.sc.webs.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 20:40
 **/
@ToString
@Getter
@Setter
public class User implements Serializable {
    private Integer id;
    private String ucode;
    private String uname;
    private String email;
}
