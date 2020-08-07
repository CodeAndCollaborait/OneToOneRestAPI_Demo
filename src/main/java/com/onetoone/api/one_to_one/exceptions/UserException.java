package com.onetoone.api.one_to_one.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserException extends Exception {

  /**
   * For when user not found by id.
   */
  private static final long serialVersionUID = 1L;

  public UserException(String message) {
    super(message);
  }

}