package com.msrabbit.serviceemail.consumer;

import com.msrabbit.serviceemail.api.dto.EmailDTO;
import com.msrabbit.serviceemail.domain.model.EmailModel;
import com.msrabbit.serviceemail.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {


    final EmailService mailService;

    public EmailConsumer(EmailService mailService) { this.mailService = mailService; }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDTO emailDTO) {
	var emailModel = new EmailModel();
	emailModel.setUserId(emailDTO.id());
	emailModel.setEmailTo(emailDTO.emailTo());
	emailModel.setSubject(emailDTO.subject());
	emailModel.setText(emailDTO.text());
	mailService.sendEmail(emailModel);
    }
}
