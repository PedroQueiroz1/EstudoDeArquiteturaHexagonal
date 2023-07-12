package com.hexagonal.adapters.in.consumer.message;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CustomerMessage {

    private String id;
    private String name;
    private String zipCode;
    private String cpf;
    private boolean isValidCpf;

}
