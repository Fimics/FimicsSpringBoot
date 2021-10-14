package com.mic.boot.controller

import com.mic.boot.config.JDBCConfig
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
open class BootController {

    companion object{
         val dbConfig = JDBCConfig()
    }

    @GetMapping("/getname")
    open fun getName():String{
        return "hello ,Spring Boot"
    }

    @GetMapping("/dbconfig")
    fun dbConfig():String{
        return  dbConfig.dataSource().toString()
    }

}