package com.hexagonal.application.ports.in;

import com.hexagonal.application.core.domain.Customer;

public interface DeleteCustomerByIdInputPort {

    void delete(String id);
}
