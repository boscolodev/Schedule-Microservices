package com.gbs.apiuser.api.dto.address;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AddressRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String cep;
    private String logradouro;
    @NotEmpty
    private String numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private String observacao;
}
