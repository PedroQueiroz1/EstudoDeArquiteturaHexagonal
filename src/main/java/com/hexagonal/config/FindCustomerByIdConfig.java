package com.hexagonal.config;

import com.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.hexagonal.adapters.out.InsertCustomerAdapter;
import com.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
