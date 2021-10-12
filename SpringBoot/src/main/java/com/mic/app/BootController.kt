package com.mic.app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class BootController {

    @GetMapping("/getname")
    open fun getName():String{
        return "hello ,Spring Boot"
    }
}