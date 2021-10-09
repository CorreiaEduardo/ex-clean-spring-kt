package com.duj.example.cleankt.api.entrypoint.queue

import com.duj.example.api.util.ApplicationLogger
import com.duj.example.cleankt.api.entrypoint.queue.message.ExampleMessage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ExampleQueueConsumer {

    companion object : ApplicationLogger()

    @RabbitListener(queues = ["\${ecosystem.queue.example_queue}"])
    fun receive(message: ExampleMessage) {
        logger.info(message.toString())
    }
}