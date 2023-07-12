package com.hexagonal.adapters.in.consumer;

import com.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "hexagonal")
    public void receive(CustomerMessage customerMessage) {
        Customer customer = customerMessageMapper.toCostumer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
