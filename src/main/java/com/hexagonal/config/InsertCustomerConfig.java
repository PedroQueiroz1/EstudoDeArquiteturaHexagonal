package com.hexagonal.config;

import com.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.hexagonal.adapters.out.InsertCustomerAdapter;
import com.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            SendCpfValidationAdapter sendCpfValidationAdapter,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter
    ) {
        return new InsertCustomerUseCase(sendCpfValidationAdapter, findAddressByZipCodeAdapter, insertCustomerAdapter);
    }
}
