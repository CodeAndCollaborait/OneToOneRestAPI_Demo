package com.onetoone.api.one_to_one.service;

import java.util.Optional;
import com.onetoone.api.one_to_one.model.Address;
import com.onetoone.api.one_to_one.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  @Autowired
  private AddressRepository addressRepository;

  public Optional<Address> findAddressByID(long id) {
    return addressRepository.findById(id);
  }

  public Address addAddress(Address address) {
    return addressRepository.save(address);
  }

}