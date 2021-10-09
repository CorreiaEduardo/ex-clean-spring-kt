package com.duj.example.cleankt.api.gateway.rabbit.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitAdmin
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.annotation.PostConstruct

@Configuration
@EnableRabbit
class RabbitConfig @Autowired constructor(
    private val rabbitQueueConfigList: List<RabbitQueueConfig>
) {

    @Value("\${ecosystem.rabbit.virtual_host}")
    private lateinit var virtualHost: String

    @Value("\${ecosystem.rabbit.username}")
    private lateinit var username: String

    @Value("\${ecosystem.rabbit.password}")
    private lateinit var password: String

    @Value("\${ecosystem.rabbit.hostname}")
    private lateinit var hostname: String

    @Value("\${ecosystem.rabbit.port}")
    private var port = 5672

    @PostConstruct
    fun setup() {
        rabbitQueueConfigList.forEach {
            with(amqpAdmin()) {
                declareExchange(it.exchange())
                declareQueue(it.deadLetterQueue())
                declareQueue(it.queue())
                declareBinding(it.deadLetterBinding())
                declareBinding(it.queueBinding())
            }
        }
    }

    @Bean
    fun connectionFactory() =
        CachingConnectionFactory(hostname, port)
            .apply {
                virtualHost = this@RabbitConfig.virtualHost
                username = this@RabbitConfig.username
                setPassword(this@RabbitConfig.password)
            }

    @Bean
    fun amqpAdmin() = RabbitAdmin(connectionFactory()).apply {
        isAutoStartup = true
        setExplicitDeclarationsOnly(true)
    }

    @Bean
    fun rabbitTemplate() =
        RabbitTemplate(connectionFactory())
            .apply {
                messageConverter = jsonMessageConverter()
            }

    @Bean
    @Primary
    fun jsonMessageConverter() = Jackson2JsonMessageConverter(ObjectMapper())

}