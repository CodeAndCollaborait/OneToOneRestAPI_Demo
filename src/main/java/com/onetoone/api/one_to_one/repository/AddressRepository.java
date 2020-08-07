package com.onetoone.api.one_to_one.repository;

import com.onetoone.api.one_to_one.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
  
}