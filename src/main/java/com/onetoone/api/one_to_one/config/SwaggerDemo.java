package com.onetoone.api.one_to_one.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerDemo {

  @GetMapping(value = "/users")
  public List<String> getUserAddress() {
    List<String> userAddressList = new ArrayList<>();
    userAddressList.add("userOne");
    userAddressList.add("userTwo");
    return userAddressList;
  }

}