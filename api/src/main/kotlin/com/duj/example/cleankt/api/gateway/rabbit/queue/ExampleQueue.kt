package com.duj.example.cleankt.api.gateway.rabbit.queue

import com.duj.example.cleankt.api.gateway.rabbit.config.RabbitQueueConfig
import org.springframework.amqp.core.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class ExampleQueue : RabbitQueueConfig {
    @Value("\${ecosystem.queue.example_queue}")
    private lateinit var queueName: String

    @Value("\${ecosystem.queue.example_dlq}")
    private lateinit var deadLetterQueueName: String

    @Value("\${ecosystem.queue.example_ex}")
    private lateinit var exchangeName: String

    @Bean(name = ["ExampleQueueExchange"])
    override fun exchange() = DirectExchange(exchangeName)

    @Bean(name = ["ExampleQueue"])
    override fun queue(): Queue {
        return QueueBuilder
            .durable(queueName)
            .withArgument("x-dead-letter-exchange", exchangeName)
            .withArgument("x-dead-letter-routing-key", deadLetterQueueName)
            .build()
    }

    @Bean(name = ["ExampleDeadLetterQueue"])
    override fun deadLetterQueue(): Queue {
        return QueueBuilder
            .durable(deadLetterQueueName)
            .build()
    }

    @Bean(name = ["ExampleQueueBinding"])
    override fun queueBinding(): Binding = BindingBuilder
        .bind(queue())
        .to(exchange())
        .with(queueName)

    @Bean(name = ["ExampleDeadLetterQueueBinding"])
    override fun deadLetterBinding(): Binding = BindingBuilder
        .bind(deadLetterQueue())
        .to(exchange())
        .with(deadLetterQueueName)
}