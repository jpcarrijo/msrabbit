package com.msrabbit.serviceemail.api.dto;

import com.msrabbit.serviceemail.domain.enums.StatusEmail;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmailFrom(
    UUID id,
    UUID userId,
    String emailFrom,
    String emailTo,
    String subject,
    String text,
    LocalDateTime sendDateEmail,
    StatusEmail statusEmail) {
}
