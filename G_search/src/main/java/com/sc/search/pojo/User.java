package com.sc.search.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.solr.client.solrj.beans.Field;

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
    @Field(value = "item_title")
    private String ucode;
    @Field(value = "item_price")
    private String uname;
    @Field(value = "item_image")
    private String email;
}
