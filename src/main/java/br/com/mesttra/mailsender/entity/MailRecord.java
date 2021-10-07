package br.com.mesttra.mailsender.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;


@Data
@Document(collection = "mailRecord")
public class MailRecord {

    @Id
    private String id;

    @Field(name = "time_Sent")
    private LocalDateTime timeSent;

    private String destination;

    private String content;

}
