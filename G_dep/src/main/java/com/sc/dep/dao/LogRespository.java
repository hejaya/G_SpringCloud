package com.sc.dep.dao;

import com.sc.dep.pojo.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/8/2 13:04
 **/

public interface LogRespository extends MongoRepository<Log,String> {
}
