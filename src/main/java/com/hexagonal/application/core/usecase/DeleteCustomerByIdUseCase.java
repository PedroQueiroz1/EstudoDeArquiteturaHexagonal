package com.hexagonal.application.core.usecase;

import com.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import com.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(
            FindCustomerByIdOutputPort findCustomerByIdOutputPort,
            DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdOutputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
