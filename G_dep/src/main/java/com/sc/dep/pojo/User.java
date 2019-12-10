package com.sc.dep.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/29 20:40
 **/
@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ucode;
    private String uname;
    private String email;
}
