package com.mic.jpa;

import com.mic.jpa.domain.Customer;
import com.mic.jpa.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpqlTest2 {

    //查询全部
    @Test
    public void testFindAll(){
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx =em.getTransaction();
        tx.begin();
        String select = "from com.mic.jpa.domain.Customer";
        Query query = em.createQuery(select);
        List<Customer> list = query.getResultList();
        for (Customer c:list) {
            System.out.println(c);
        }
        tx.commit();
        em.close();
    }

    @Test
    public void testOrder(){
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx =em.getTransaction();
        tx.begin();
        String select = "from Customer order by custId";
        Query query = em.createQuery(select);
        List<Customer> list = query.getResultList();
        for (Customer c:list) {
            System.out.println(c);
        }
        tx.commit();
        em.close();
    }

    @Test
    public void testCount(){
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx =em.getTransaction();
        tx.begin();
        String select = "select count(custId) from Customer";
        Query query = em.createQuery(select);
        Object result = query.getSingleResult();
        System.out.println(result);
        tx.commit();
        em.close();
    }

    @Test
    public void testPaged(){
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx =em.getTransaction();
        tx.begin();
        String select = "from Customer";
        Query query = em.createQuery(select);
        //起始查询的条数
        query.setFirstResult(0);
        //每页查询的条数
        query.setMaxResults(2);
        List<Customer> list = query.getResultList();
        for (Customer c:list) {
            System.out.println(c);
        }
        tx.commit();
        em.close();
    }

    @Test
    public void testCondition(){
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx =em.getTransaction();
        tx.begin();
        String select = "from Customer where custId=94";
        Query query = em.createQuery(select);
        //起始查询的条数
        query.setFirstResult(0);
        //每页查询的条数
        query.setMaxResults(2);
        List<Customer> list = query.getResultList();
        for (Customer c:list) {
            System.out.println(c);
        }
        tx.commit();
        em.close();
    }
}
