package br.com.mesttra.mailsender.controller;

import br.com.mesttra.mailsender.dto.MailDTO;
import br.com.mesttra.mailsender.entity.MailRecord;
import br.com.mesttra.mailsender.service.MailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mails")
public class MailController {

    MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    public MailRecord sendMail(@RequestBody MailDTO mail) {
        return mailService.sendMail(mail);
    }

}
