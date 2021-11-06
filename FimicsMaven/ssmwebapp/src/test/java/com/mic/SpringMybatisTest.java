package com.mic;


import com.mic.pojo.Item;
import com.mic.service.ItemService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml","classpath:applicationContext-service.xml"})
public class SpringMybatisTest {
    @Autowired
    public ItemService itemService;

    @Test
    public void test1(){
        Item item = itemService.findById(1);
        System.out.println(item);
    }
}
