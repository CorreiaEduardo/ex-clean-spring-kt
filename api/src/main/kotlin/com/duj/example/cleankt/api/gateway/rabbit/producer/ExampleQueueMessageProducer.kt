package com.duj.example.cleankt.api.gateway.rabbit.producer

import com.duj.example.cleankt.api.gateway.rabbit.message.ExampleMessage
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ExampleQueueMessageProducer @Autowired constructor(
    private val rabbitTemplate: RabbitTemplate
) {
    @Value("\${ecosystem.queue.example_queue}")
    private lateinit var queueName: String

    @Value("\${ecosystem.queue.example_ex}")
    private lateinit var exchangeName: String

    fun send(message: ExampleMessage) {
        rabbitTemplate.convertAndSend(exchangeName, queueName, message)
    }
}