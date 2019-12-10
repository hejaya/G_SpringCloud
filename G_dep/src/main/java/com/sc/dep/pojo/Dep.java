package com.sc.dep.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/30 7:44
 **/
@Entity
@Table(name = "dep")
@Getter
@Setter
@ToString
public class Dep implements Serializable {

    @Id
    private String id;
    private String name;
    private String address;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinColumn(name="uid")
    private User user;

    //private Integer uid;
}
