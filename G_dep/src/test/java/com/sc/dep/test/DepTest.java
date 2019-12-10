package com.sc.dep.test;

import com.sc.dep.DepApplication;
import com.sc.dep.dao.DepRepository;
import com.sc.dep.dao.MenuMapper;
import com.sc.dep.pojo.Dep;
import com.sc.dep.pojo.Menu;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Gthree
 * @Mood: Pumped Up
 * @Date: 2019/9/3 7:56
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DepApplication.class)
public class DepTest {

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    DepRepository depRepository;

    @Test
    public void testMenu() {
        List<Menu> menus = menuMapper.selectAllByPid(0);
        System.out.println("menus = " + menus);
    }

    @Test
    public void testNull() {
        Md5Hash md5Hash = new Md5Hash("123456", "marong", 2);
        System.out.println("md5Hash = " + md5Hash.toString());
    }

    @Test
    @Transactional
    public void testCa() {
        Dep dep = depRepository.getOne("00cde0b9ee4c4e7d93ff990b49ea4af1");
        String uname = dep.getUser().getUname();
        dep.setName("啛啛喳喳错错错错错错错错错错错错错错错错错错");
    }

}
