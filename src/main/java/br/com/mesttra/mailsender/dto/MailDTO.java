package br.com.mesttra.mailsender.dto;

import lombok.Data;

@Data
public class MailDTO {

    private String to;
    private String subject;
    private String content;

}
