package com.msrabbit.serviceuser.controller;

import com.msrabbit.serviceuser.domain.protocols.UserInterface;
import com.msrabbit.serviceuser.api.dto.UserDTO;
import com.msrabbit.serviceuser.api.dto.UserForm;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    final UserInterface userInterface;

    public UserController(UserInterface userInterface) { this.userInterface = userInterface; }

    @PostMapping("/insert")
    public ResponseEntity<UserDTO> saveUser(@RequestBody @Valid UserForm userForm) {
	return ResponseEntity.status(HttpStatus.CREATED).body(userInterface.saveUser(userForm));
    }
}
