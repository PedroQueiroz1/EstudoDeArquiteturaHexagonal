package com.hexagonal.adapters.in.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data

public class CustomerRequest {

    //Não precisa do ID porque o mongo já cria automaticamente
    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String zipCode;

}
