package com.mic.jpa;

import com.mic.jpa.domain.Customer;
import com.mic.jpa.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest1 {



    @Test
    public void testSave(){
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx =em.getTransaction();
        tx.begin();

        Customer customer = new Customer();
        customer.setCustAddress("shanghai");
        customer.setCustLevel("1");
        customer.setCustName("python");
        customer.setCustIndustry("edu");
        customer.setCustPhone("15313195277");
        em.persist(customer);
        // merge 更新， remove 删除，find/getRefrence 查询
        tx.commit();
        em.close();
    }

    //立即加载
    @Test
    public void testFind(){
        EntityManager em =JpaUtils.getEntityManager();
        EntityTransaction tx =em.getTransaction();
        tx.begin();
        Customer customer = em.find(Customer.class,94l);
        System.out.println(customer);
        tx.commit();
        em.close();
    }

    //延迟加载
    @Test
    public void testReference(){
        EntityManager em =JpaUtils.getEntityManager();
        EntityTransaction tx =em.getTransaction();
        tx.begin();
        Customer customer = em.getReference(Customer.class,94l);
        System.out.println(customer);
        tx.commit();
        em.close();
    }
}
