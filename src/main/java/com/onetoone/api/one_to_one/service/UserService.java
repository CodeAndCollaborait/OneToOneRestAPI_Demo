package com.onetoone.api.one_to_one.service;

import com.onetoone.api.one_to_one.exceptions.UserException;
import com.onetoone.api.one_to_one.model.User;
import com.onetoone.api.one_to_one.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  // GET list of user
  public Page<User> getListOfUsers(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  // GET user by id
  public User userById(long id) throws UserException {
    return userRepository.findById(id).orElseThrow(() -> new UserException("User not found by the given id: " + id));
  }

  // POST Single User only
  public User addUser(User user) {
    return userRepository.save(user);
  }

  

}