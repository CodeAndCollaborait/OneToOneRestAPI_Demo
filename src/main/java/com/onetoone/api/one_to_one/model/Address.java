package com.onetoone.api.one_to_one.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "address")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends AuditModel {

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "street_number", nullable = false)
  private long streetNumber;

  @Column(name = "street_name", nullable = false)
  private String streetName;

  @Column(name = "zipcode", nullable = false)
  private int zipcode;

  @OneToOne
  @MapsId
  private User user;

  public Address() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(long streetNumber) {
    this.streetNumber = streetNumber;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public int getZipcode() {
    return zipcode;
  }

  public void setZipcode(int zipcode) {
    this.zipcode = zipcode;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}