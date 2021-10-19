package com.mic.boot.config

import com.mic.boot.interceptor.MyInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
open class MvcConfig():WebMvcConfigurer {

    //注册拦截器
    open fun myInterceptor():MyInterceptor{
        return MyInterceptor()
    }

    //添加拦截器到spring mvc 拦截器链
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(myInterceptor()).addPathPatterns("/*")
    }
}