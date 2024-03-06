package com.msrabbit.serviceemail.service;

import com.msrabbit.serviceemail.domain.enums.StatusEmail;
import com.msrabbit.serviceemail.domain.model.EmailModel;
import com.msrabbit.serviceemail.domain.protocols.EmailInterface;
import com.msrabbit.serviceemail.domain.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailService implements EmailInterface {


    final EmailRepository emailRepository;
    final JavaMailSender mailSender;

    @Value(value = "${spring.mail.username}")
    private String mailFrom;


    @Override
    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
	try {
	    emailModel.setSendDateEmail(LocalDateTime.now());
	    emailModel.setEmailFrom(mailFrom);

	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo(emailModel.getEmailTo());
	    message.setSubject(emailModel.getSubject());
	    message.setText(emailModel.getText());
	    mailSender.send(message);

	    emailModel.setStatusEmail(StatusEmail.SENT);
	    System.out.println(emailModel.getStatusEmail());
	} catch (MailException ex) {
	    emailModel.setStatusEmail(StatusEmail.ERROR);
	    System.out.println(emailModel.getStatusEmail());
	}
	return emailRepository.save(emailModel);
    }
}
