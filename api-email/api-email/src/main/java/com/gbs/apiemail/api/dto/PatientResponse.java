package com.gbs.apiemail.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


public record PatientResponse(
        @NotNull(message = "Id não pode ser nulo")
        Long id,

        @NotEmpty(message = "Nome não pode ser vazio ou nulo")
        String name,
        @Email(message = "Digite um e-mail válido")
        String email,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthday,
        AddressResponse address,
        @NotEmpty
        String status
) {
}
