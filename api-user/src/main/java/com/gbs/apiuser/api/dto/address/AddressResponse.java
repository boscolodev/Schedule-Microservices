package com.gbs.apiuser.api.dto.address;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AddressResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String numero;
    private String uf;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String observacao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

}
