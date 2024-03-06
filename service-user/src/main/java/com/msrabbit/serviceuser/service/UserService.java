package com.msrabbit.serviceuser.service;

import com.msrabbit.serviceuser.domain.model.UserModel;
import com.msrabbit.serviceuser.domain.protocols.UserInterface;
import com.msrabbit.serviceuser.domain.repository.UserRepository;
import com.msrabbit.serviceuser.api.dto.UserDTO;
import com.msrabbit.serviceuser.api.dto.UserForm;
import com.msrabbit.serviceuser.producer.UserProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements UserInterface {


    final UserRepository userRepository;
    final UserProducer userProducer;

    @Override
    @Transactional
    public UserDTO saveUser(UserForm userForm) {
	var userModel = new UserModel();
	userModel.setName(userForm.name());
	userModel.setEmail(userForm.email());
	userModel = userRepository.save(userModel);

	userForm = new UserForm(userModel.getId(), userModel.getName(), userModel.getEmail());
	userProducer.pubMessageEmail(userForm);
	return new UserDTO(userForm.name(), userForm.email());
    }
}
