package com.gbs.apiemail.api.dto.doctor;

import com.gbs.apiemail.api.dto.address.AddressResponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record DoctorResponse(
        @NotNull(message = "Id não pode ser nulo")
        Long id,
        @NotEmpty(message = "Nome não pode ser vazio ou nulo")
        String name,
        @Email(message = "Digite um e-mail válido")
        String email,
        AddressResponse address

) {
}
