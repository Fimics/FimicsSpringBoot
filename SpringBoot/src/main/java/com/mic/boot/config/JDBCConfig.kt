package com.mic.boot.config

import com.alibaba.druid.pool.DruidDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import javax.sql.DataSource

//@Configuration
//@PropertySource("classpath:jdbc.properties")
//@EnableConfigurationProperties(JdbcProperties::class)
open class JDBCConfig{

    @Value("${"jdbc.url"}")
    var url:String=""
    @Value("${"jdbc.driverClassName"}")
    var driver:String=""
    @Value("${"jdbc.username"}")
    var username:String=""
    @Value("${"jdbc.password"}")
    var password:String=""

//    fun dataSource():DataSource{
//        val ds :DruidDataSource = DruidDataSource()
//        ds.driverClassName=driver
//        ds.url=url
//        ds.username=username
//        ds.password=password
//        return ds
//    }

//    @Bean
//    open fun dataSource(jdbcProperties: JdbcProperties):DataSource{
//        val ds :DruidDataSource = DruidDataSource()
//        ds.driverClassName=jdbcProperties.driverClassName
//        ds.url=jdbcProperties.url
//        ds.username=jdbcProperties.username
//        ds.password=jdbcProperties.password
//        return ds
//    }

//    @Bean
//    @ConfigurationProperties(prefix = "jdbc")
//    open fun dataSource1():DataSource{
//        return DruidDataSource()
//    }
}