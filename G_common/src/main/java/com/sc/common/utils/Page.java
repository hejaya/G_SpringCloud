package com.sc.common.utils;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/8 10:32
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Page<T> implements Serializable {

    private List<T> data;//包含实际数据的数组
    private Integer page;//当前页
    private Integer rows;//总的页数
    private Long totalCount;//总的记录数（查出来的总条数）

}
