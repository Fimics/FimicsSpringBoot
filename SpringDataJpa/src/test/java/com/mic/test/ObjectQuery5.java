package com.mic.test;

import com.mic.dao.CustomerDao;
import com.mic.dao.LinkManDao;
import com.mic.domain.Customer;
import com.mic.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.Set;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ObjectQuery5 {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private LinkManDao linkManDao;

    //测试对象导航(查询一个对象的时候，通过此对象查询所有的关联对象)
    //从一的一方查找多的一方
    @Test
    @Transactional
    public void testQuery(){
        Customer customer= customerDao.getOne(1l);
        Set<LinkMan> linkMans = customer.getLinkMans();
        System.out.println(linkMans.size());
        Stream.of(linkMans).forEach(System.out::println);
    }

    //从联系人对象导航查询他的所有客户 从多的一方查找一的一方
    @Test
    @Transactional
    public void testQuery1(){
        LinkMan linkMan = linkManDao.findOne(2l);
        Customer customer = linkMan.getCustomer();
        System.out.println(customer);
    }

}
