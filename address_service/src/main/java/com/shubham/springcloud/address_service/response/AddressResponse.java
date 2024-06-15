package com.shubham.springcloud.address_service.response;

import com.shubham.springcloud.address_service.entity.Address;

public class AddressResponse {

    private Long id;

    private String street;

    private String city;

    public AddressResponse(Address address){
        this.id = address.getId();
        this.city = address.getCity();
        this.street = address.getStreet();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
