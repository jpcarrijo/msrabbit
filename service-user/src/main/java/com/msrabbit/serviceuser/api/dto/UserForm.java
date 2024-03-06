package com.msrabbit.serviceuser.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UserForm(
    UUID id,
    @NotBlank String name,
    @NotBlank @Email String email
) {
}
