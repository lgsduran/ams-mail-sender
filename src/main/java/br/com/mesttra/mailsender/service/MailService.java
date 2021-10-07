package br.com.mesttra.mailsender.service;

import br.com.mesttra.mailsender.dto.MailDTO;
import br.com.mesttra.mailsender.entity.MailRecord;
import br.com.mesttra.mailsender.repository.MailRecordRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MailService {

    MailRecordRepository mailRecordRepository;
    JavaMailSender javaMailSender;

    public MailService(MailRecordRepository mailRecordRepository, JavaMailSender javaMailSender) {
        this.mailRecordRepository = mailRecordRepository;
        this.javaMailSender = javaMailSender;
    }

    public MailRecord sendMail(MailDTO mailDTO) {

        String content = mailDTO.getContent();                
        String destination = mailDTO.getTo();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(destination);
        message.setText(content);
        message.setSubject(mailDTO.getSubject());
        message.setFrom("lgsduran@gmail.com");
        javaMailSender.send(message);

        MailRecord mailRecord = new MailRecord();
        mailRecord.setContent(content);
        mailRecord.setDestination(destination);
        mailRecord.setTimeSent(LocalDateTime.now());

        return mailRecordRepository.save(mailRecord);
    }

}
