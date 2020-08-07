package com.onetoone.api.one_to_one.controller;

import java.util.Optional;

import com.onetoone.api.one_to_one.exceptions.UserException;
import com.onetoone.api.one_to_one.model.Address;
import com.onetoone.api.one_to_one.model.User;
import com.onetoone.api.one_to_one.service.AddressService;
import com.onetoone.api.one_to_one.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private AddressService addressService;

  @GetMapping(value = "/")
  public String testApi() {
    return "Hello User/Address api using Swagger";
  }

  @GetMapping(value = "/users")
  public Page<User> getListOfUsers(Pageable pageable) {
    return userService.getListOfUsers(pageable);
  }

  @GetMapping(value = "/users/{user_id}")
  public User findUserById(@PathVariable(value = "user_id") long user_id) throws UserException {
    return userService.userById(user_id);
  }

  @GetMapping(value = "/users/{user_id}/address")
  public Optional<Address> findAddressOfUser(@PathVariable(value = "user_id") long user_id) throws UserException {
    //What if address value is null./??? 
    return addressService.getAddressById(user_id);
  }

  @PostMapping(value = "/users")
  public User saveUser(@RequestBody User user) {
    return userService.addUser(user);
  }

  /**
   * User and Address ... (Address must have user.. but user can be without
   * address) TODO GET /api/v1/users (list of all user not include Address), TODO
   * /api/v1/users/{user_id}/address(based on user_id)(user name, user_id, address
   * info) TODO GET by ID /api/v1/users/{user_id}..user info based on
   * user_id.(user_id, name) POST, PUT-id DELETE-id
   */

}