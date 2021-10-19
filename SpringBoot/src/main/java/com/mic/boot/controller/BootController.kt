package com.mic.boot.controller

import com.mic.boot.config.JDBCConfig
import com.mic.boot.pojo.User
import com.mic.boot.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import javax.sql.DataSource

@RestController
open class BootController {

    companion object{
         val dbConfig = JDBCConfig()
    }

    @Autowired
    var dataSourceApp:DataSource?=null

    @Autowired
    lateinit var userService:UserService

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
//        return  dbConfig.dataSource1().toString()
        return "datasource config 1"
    }

    @GetMapping("/ymlconfig")
    fun ymlConfig(){
        println(dataSourceApp?.connection)
        println(itcastUrl)
        println(itheimaUrl)
    }

    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/user/{id}")
    fun queryById(@PathVariable id:Long):User{
          return userService.queryById(id)
    }
}