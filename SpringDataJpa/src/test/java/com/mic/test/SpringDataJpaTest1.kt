package com.mic.test

import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.ContextConfiguration
import org.springframework.beans.factory.annotation.Autowired
import com.mic.dao.CustomerDao
import com.mic.domain.Customer
import org.junit.Test
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(locations = ["classpath:applicationContext.xml"])
open class SpringDataJpaTest1 {
    @Autowired
    var dao: CustomerDao? = null

    @Test
    fun testFindOne() {
        val customer = dao!!.findOne(94L)
        println(customer)
    }

    @Test
    fun testSave() {
        val customer = Customer()
        customer.custId = 96L
        customer.custName = "c++"
        //save 可以保存又可以更新
        dao!!.save(customer)
    }

    @Test
    fun testFindAll() {
        val list = dao!!.findAll()
        list.forEach(::println)
    }

    @Test
    fun testCount() {
        var count = dao?.count()
        var exists: Boolean = dao?.exists(94) == true
        println(exists)
        println(count)
    }

    /**
     * findOne em.find立即加载
     * em.getReference 延迟加载
     * dao.getOne() 返回一个代理对象，延迟加载 ，啥时候用啥时候加载
     */

    @Test
    @Transactional
    open fun testGetOne() {
        var customer = dao?.getOne(95)
        println(customer)
    }

    @Test
    fun testFindByName() {
        var customer = dao?.findByCustName1("java")
        println(customer)
    }

    @Test
    fun testFindByNameAndId() {
        var customer = dao?.findByNameAndId("python", 95)
        println(customer)
    }

    //更新，删除操作 需要事物的支持
    @Test
    @Transactional
    @Rollback(value = false)
    open fun testUpdate() {
        var customer = dao?.updateByNameAndId(94, "python1")
        println(customer)
    }

    @Test
    fun findAllSql() {
        var list = dao?.findAllSql()
        list?.forEach(::println)
    }

    @Test
    fun findAllWithLike() {
        var list = dao?.findAllWithLike("python1")
        list?.forEach(::println)
    }

    @Test
    fun testFindByCustName() {
        var customer = dao?.findByCustName("c++")
        println(customer)
    }
}