package com.duj.example.cleankt.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication(scanBasePackages = ["com.duj.example.cleankt"])
@EnableJpaAuditing
@EnableJpaRepositories
class AppStarter {
    @PostConstruct
    fun started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"))
    }
}

fun main(args: Array<String>) {
    runApplication<AppStarter>(*args)
}
