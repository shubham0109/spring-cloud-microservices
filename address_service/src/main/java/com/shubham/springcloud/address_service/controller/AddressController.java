package com.shubham.springcloud.address_service.controller;


import com.shubham.springcloud.address_service.request.CreateAddressRequest;
import com.shubham.springcloud.address_service.response.AddressResponse;
import com.shubham.springcloud.address_service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("health")
    public String getById(){
        return "healthy";
    }

    @PostMapping("/create")
    public AddressResponse create(@RequestBody CreateAddressRequest addressRequest){
        return addressService.create(addressRequest);
    }

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

}
