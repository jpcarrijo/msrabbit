package com.msrabbit.serviceuser.producer;

import com.msrabbit.serviceuser.api.dto.EmailDTO;
import com.msrabbit.serviceuser.api.dto.UserForm;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {


    final RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public UserProducer(RabbitTemplate rabbitTemplate) { this.rabbitTemplate = rabbitTemplate; }

    public void pubMessageEmail(UserForm userForm) {
	var emailDTO = new EmailDTO(
	    userForm.id(),
	    userForm.email(),
	    "Cadastro realizado com sucesso!",
	    userForm.name() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro. Aproveite agora todos os recursos " +
		"da" +
		" nossa plataforma"
	);
	rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
