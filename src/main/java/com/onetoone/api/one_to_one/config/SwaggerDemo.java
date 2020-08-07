package com.onetoone.api.one_to_one.config;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerDemo {

  @GetMapping(value = "/users")
  public HashMap<String, String> getUserAddress() {
    HashMap<String, String> response = new HashMap<>();
    response.put("id", "1");
    response.put("name", "UserName");
    return response;

  }

}