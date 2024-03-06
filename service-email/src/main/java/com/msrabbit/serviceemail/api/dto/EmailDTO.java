package com.msrabbit.serviceemail.api.dto;

import java.util.UUID;

public record EmailDTO(
    UUID id,
    String emailTo,
    String subject,
    String text) {
}
