package com.sc.search;

import com.sc.search.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @Author: Gthree
 * @Mood: Pumped Up
 * @Date: 2019/9/9 16:08
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class SearchTest {

    @Autowired
    private SolrTemplate solrTemplate;

    @Test
    public void testSearch(){
        Optional<User> user = solrTemplate.getById("", "536563", User.class);
        user.ifPresent(value -> System.out.println("user = " + value));
    }
    @Test
    public void testDelSearch(){
        SimpleQuery simpleQuery = new SimpleQuery("*:*");
        solrTemplate.delete("collection1",simpleQuery);
        solrTemplate.commit("collection1");
    }
}
