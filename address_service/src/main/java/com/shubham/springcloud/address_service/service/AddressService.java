package com.shubham.springcloud.address_service.service;

import com.shubham.springcloud.address_service.entity.Address;
import com.shubham.springcloud.address_service.repository.AddressRepository;
import com.shubham.springcloud.address_service.request.CreateAddressRequest;
import com.shubham.springcloud.address_service.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressResponse create(CreateAddressRequest addressRequest){
        Address address = new Address();
        address.setId(addressRequest.getId());
        address.setCity(addressRequest.getCity());
        address.setStreet(addressRequest.getStreet());

        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getAddressById(Long id){
        Address address = addressRepository.findById(id).orElseThrow(()-> new NoSuchElementException());

        return new AddressResponse(address);


    }


}
