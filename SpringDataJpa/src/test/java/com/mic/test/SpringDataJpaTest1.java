package com.mic.test;

import com.mic.dao.CustomerDao;
import com.mic.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataJpaTest1 {

    @Autowired
    private CustomerDao dao;

    @Test
    public void testFindOne(){
        Customer customer = dao.findOne(94l);
        System.out.println(customer);
    }
}
