package com.mic.test;


import com.mic.dao.CustomerDao;
import com.mic.dao.LinkManDao;
import com.mic.domain.Customer;
import com.mic.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest3 {

    @Autowired
    private CustomerDao cDao;
    @Autowired
    private LinkManDao lDao;

    //保存一个customer 和一个linkMan
    @Test
    @Transactional
    @Rollback(value = false)
    public void testSave(){
        Customer customer = new Customer();
        customer.setCustName("baidu");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("lishi");

//        customer.getLinkMans().add(linkMan);

        cDao.save(customer);
        linkMan.setCustomer(customer);
        lDao.save(linkMan);

    }


    //保存一个customer 和一个linkMan  级联添加
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeSave(){
        Customer customer = new Customer();
        customer.setCustName("baidu");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("lishi");

//        customer.getLinkMans().add(linkMan);

        cDao.save(customer);
        linkMan.setCustomer(customer);
        lDao.save(linkMan);
    }

    //保存一个customer 和一个linkMan  级联添加
    @Test
    @Transactional
    @Rollback(value = false)
    public void testCascadeRemove(){
       Customer customer=cDao.findOne(15l);
       cDao.delete(customer);
    }



}
