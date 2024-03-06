package com.msrabbit.serviceuser.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record EmailDTO(
    @JsonProperty(value = "id")
    UUID id,
    @JsonProperty(value = "emailTo")
    String emailTo,
    @JsonProperty(value = "subject")
    String subject,
    @JsonProperty(value = "text")
    String text) {
}
