package br.com.mesttra.mailsender.amqp;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	public static String EXCHANGE_NAME = "order-exchange";

    public static final String NOTIFICATION_QUEUE = "order-notification-queue";

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
