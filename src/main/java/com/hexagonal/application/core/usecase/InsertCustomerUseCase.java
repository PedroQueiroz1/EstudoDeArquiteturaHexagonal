package com.hexagonal.application.core.usecase;

import com.hexagonal.application.core.domain.Address;
import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.hexagonal.application.ports.out.SendCpfValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfValidationOutputPort sendCpfValidationOutputPort;

    public InsertCustomerUseCase(
            SendCpfValidationOutputPort sendCpfValidationOutputPort,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort
    ) {
        this.sendCpfValidationOutputPort = sendCpfValidationOutputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfValidationOutputPort.send(customer.getCpf());
    }
}
