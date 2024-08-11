package kz.sameapp.kz.sameapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import reactivefeign.spring.config.EnableReactiveFeignClients

@SpringBootApplication
@EnableReactiveFeignClients("\${spring.reactive-feign.base-package}")
@ConfigurationPropertiesScan(basePackages = ["kz.sameapp"])
@ComponentScan(basePackages = ["kz.sameapp.sameclient"])
@EnableR2dbcRepositories("kz.sameapp")
class SameAppApplication

fun main(args: Array<String>) {
    runApplication<SameAppApplication>(*args)
}
