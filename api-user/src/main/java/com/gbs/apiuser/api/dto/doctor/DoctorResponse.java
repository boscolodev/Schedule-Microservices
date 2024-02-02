package com.gbs.apiuser.api.dto.doctor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gbs.apiuser.api.dto.address.AddressResponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DoctorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @NotNull(message = "Id não pode ser nulo")
    private Long id;
    @NotEmpty(message = "Nome não pode ser vazio ou nulo")
    private String name;
    @Email(message = "Digite um e-mail válido")
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;
    private AddressResponse address;
    @NotEmpty
    private String crm;
    @NotEmpty
    private String status;
}
