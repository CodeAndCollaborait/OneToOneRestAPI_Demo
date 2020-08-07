package com.onetoone.api.one_to_one.service;

import java.util.Optional;

import com.onetoone.api.one_to_one.exceptions.UserException;
import com.onetoone.api.one_to_one.model.Address;
import com.onetoone.api.one_to_one.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private UserService userService;

  // How to find address by user id?

  public Optional<Address> getAddressById(long id) throws UserException {
    // find the user with given id..
    userService.userById(id);
    return addressRepository.findById(id);
  }

}