package com.mic.jpa;

import com.mic.jpa.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest1 {



    @Test
    public void testSave(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tx =em.getTransaction();
        tx.begin();

        Customer customer = new Customer();
        customer.setCustAddress("beijing");
        customer.setCustLevel("1");
        customer.setCustName("java");
        customer.setCustIndustry("edu");
        customer.setCustPhone("15313195277");
        em.persist(customer);
        tx.commit();
        em.close();
    }
}
