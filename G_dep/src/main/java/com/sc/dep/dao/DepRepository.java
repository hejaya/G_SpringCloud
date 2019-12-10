package com.sc.dep.dao;

import com.sc.dep.pojo.Dep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: G_three
 * @Mood: Pumped Up
 * @Date: 2019/7/30 7:59
 **/

public interface DepRepository extends JpaRepository<Dep,String> {


    @Query(value = "SELECT * FROM `dep`",nativeQuery = true)
    public List<Dep> getAllBySQL();

    @Modifying
    @Query(value = "UPDATE dep SET address = '曹尼玛123456' WHERE id=?1",nativeQuery = true)
    public void updateDepBySQL(String id);
}
