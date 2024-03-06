package com.msrabbit.serviceuser.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
    @NotBlank String name,
    @NotBlank @Email String email) {
}