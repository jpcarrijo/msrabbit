package com.msrabbit.serviceuser.domain.protocols;

import com.msrabbit.serviceuser.api.dto.UserDTO;
import com.msrabbit.serviceuser.api.dto.UserForm;

public interface UserInterface {

    UserDTO saveUser(UserForm userForm);
}
