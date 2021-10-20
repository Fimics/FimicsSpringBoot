package com.mic.dao;

import com.mic.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SuppressWarnings("unsed")
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {

    //jpsl 注解方式
    @Query(value = "from Customer where custName=?")
    public  Customer findByCustName1(String custName);

    //jpsl 注解方式 可以指定占位符的位置
    @Query(value = "from Customer where custName=?1 and custId = ?2")
    public  Customer findByNameAndId(String custName,Long id);

    @Query(value = "update Customer  set custName= ?2 where custId = ?1")
    @Modifying
    public  void updateByNameAndId(long id,String custName);

    //查询全部数据
    @Query(value = "select * from cst_customer",nativeQuery = true)
    public List<Customer> findAllSql();

    //模糊查询  名称约定
    @Query(value = "from Customer  where custName like ?")
    public List<Customer> findAllWithLike(String name);

    //方法名约定查询
    public Customer findByCustName(String custName);

//    //方法名约定查询  模糊查询
//    public Customer findByCustNameLike(String custName);
//
//    //使用客户名称模糊查询和使用行业精准查询
//    public Customer findByCustNameLikeAnAndCustIndustry(String custName,String custIndustry);
}
