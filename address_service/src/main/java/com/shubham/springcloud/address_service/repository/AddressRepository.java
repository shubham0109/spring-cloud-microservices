package com.shubham.springcloud.address_service.repository;

import com.shubham.springcloud.address_service.entity.Address;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
