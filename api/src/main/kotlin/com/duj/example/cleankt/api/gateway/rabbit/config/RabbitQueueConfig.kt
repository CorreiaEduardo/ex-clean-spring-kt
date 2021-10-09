package com.duj.example.cleankt.api.gateway.rabbit.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue

interface RabbitQueueConfig {

    fun exchange(): DirectExchange

    fun queue(): Queue

    fun deadLetterQueue(): Queue

    fun queueBinding(): Binding

    fun deadLetterBinding(): Binding

}