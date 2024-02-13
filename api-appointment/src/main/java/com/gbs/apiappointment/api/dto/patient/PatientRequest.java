package com.gbs.apiappointment.api.dto.patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record PatientRequest(
        @NotEmpty(message = "Nome não pode ser vazio ou nulo")
        String name,
        @Email(message = "Digite um e-mail válido")
        String email
) {
}
