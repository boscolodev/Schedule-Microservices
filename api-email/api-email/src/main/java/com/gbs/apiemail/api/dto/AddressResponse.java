package com.gbs.apiemail.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public record AddressResponse(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String numero,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String observacao

) {
}
