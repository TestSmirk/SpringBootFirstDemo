package com.testsmirk

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class GirlApplication {

    fun main(args: Array<String>) {
        //SpringBoot的启动初始化
        SpringApplication.run(GirlApplication::class.java, *args)
    }
}
