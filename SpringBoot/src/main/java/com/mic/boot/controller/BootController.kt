package com.mic.boot.controller

import com.mic.boot.config.JDBCConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.sql.DataSource

@RestController
open class BootController {

    companion object{
         val dbConfig = JDBCConfig()
    }

    @Autowired
    var dataSourceApp:DataSource?=null

    @Value("\${itcast.url}")
    private val itcastUrl: String? = null

    @Value("\${itheima.url}")
    private val itheimaUrl: String? = null

    @GetMapping("/getname")
    open fun getName():String{
        return "hello ,Spring Boot"
    }

    @GetMapping("/dbconfig")
    fun dbConfig():String{
//        return  dbConfig.dataSource().toString()
        return "datasource"
    }

    @GetMapping("/dbconfigapp")
    fun dbConfigApp():String{
        return  dataSourceApp.toString()
    }

    @GetMapping("/dbconfig1")
    fun dbConfig1():String{
        return  dbConfig.dataSource1().toString()
    }

    @GetMapping("/ymlconfig")
    fun ymlConfig(){
        println(itcastUrl)
        println(itheimaUrl)
    }


}