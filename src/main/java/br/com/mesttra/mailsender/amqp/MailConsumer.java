package br.com.mesttra.mailsender.amqp;

import br.com.mesttra.mailsender.dto.MailDTO;
import br.com.mesttra.mailsender.service.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {

    MailService mailService;

    public MailConsumer(MailService mailService) {
        this.mailService = mailService;
    }

    @RabbitListener(queues = RabbitConfig.NOTIFICATION_QUEUE)
    public void consume (@Payload MailDTO mailDTO){
        mailService.sendMail(mailDTO);
    }

}
