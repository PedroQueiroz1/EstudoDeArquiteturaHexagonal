package com.hexagonal.adapters.out;

import com.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.hexagonal.adapters.out.client.response.AddressResponse;
import com.hexagonal.application.core.domain.Address;
import com.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }

}
