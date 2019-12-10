package com.sc.dep.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/8/2 13:01
 **/
@Getter
@Setter
@ToString
public class Log implements Serializable {
    private String _id;
    private String name;
    private Date udate;
}
