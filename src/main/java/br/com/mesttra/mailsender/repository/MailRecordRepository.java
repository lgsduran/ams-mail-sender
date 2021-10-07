package br.com.mesttra.mailsender.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.mesttra.mailsender.entity.MailRecord;

public interface MailRecordRepository extends MongoRepository<MailRecord, String> {

}
