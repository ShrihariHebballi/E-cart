package com.ecommerce.userauthservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.userauthservice.model.AddressDetails;

public interface AddressRepo extends JpaRepository<AddressDetails, Long> {

}
