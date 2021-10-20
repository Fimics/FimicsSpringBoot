package com.mic.test;

import com.mic.dao.CustomerDao;
import com.mic.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest2 {

    @Autowired
    private CustomerDao dao;

    /**
     * 单条件查询
     */
    @Test
    public void testFindOne(){
        Specification spec = (Specification<Customer>) (root, query, cb) -> {
             Path<String> custName=root.get("custName");
             Predicate predicate= cb.equal(custName,"c++");
            return predicate;
        };

        Customer customer = dao.findOne(spec);
        System.out.println(customer);
    }

    /**
     * 多条件查询
     */
    @Test
    public void testFindOneWithCondition(){
        Specification spec = (Specification<Customer>) (root, query, cb) -> {
            Path<String> custName=root.get("custName");
            Path<String> custIndustry = root.get("custIndustry");
            Predicate p1= cb.equal(custName,"java");
            Predicate p2 = cb.equal(custIndustry,"edu1");
            Predicate predicate = cb.and(p1,p2);
            return predicate;
        };

        Customer customer = dao.findOne(spec);
        System.out.println(customer);
    }


    /**
     * 模糊查询 排序 分页
     */
    @Test
    public void testFindWithLike(){
        Specification spec = (Specification<Customer>) (root, query, cb) -> {
            Path<String> custName=root.get("custName");
            Predicate predicate= cb.like(custName,"j%");
            return predicate;
        };

//        Sort sort = new Sort(Sort.Direction.ASC,"custId");
//        List<Customer> list = dao.findAll(spec,sort);

        Pageable pageable = new PageRequest(0,2);
        Page<Customer> page = dao.findAll(spec,pageable);
        System.out.println(page.getSize());
    }
}
