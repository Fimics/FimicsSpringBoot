package com.mic.boot.config

import com.alibaba.druid.pool.DruidDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import javax.sql.DataSource

@Configuration
@PropertySource("classpath:jdbc.properties")
open class JDBCConfig{

    @Value("${"jdbc.url"}")
    var url:String=""
    @Value("${"jdbc.driverClassName"}")
    var driver:String=""
    @Value("${"jdbc.username"}")
    var username:String=""
    @Value("${"jdbc.password"}")
    var password:String=""

    fun dataSource():DataSource{
        val ds :DruidDataSource = DruidDataSource()
        ds.driverClassName=driver
        ds.url=url
        ds.username=username
        ds.password=password
        return ds
    }
}