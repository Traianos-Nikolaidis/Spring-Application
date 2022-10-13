package com.example.traianos;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity 
@Table(name = "user")
@SecondaryTable(name = "addresses", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;
  @NotEmpty
  @Column(name = "name")
  private String name;
  @NotEmpty
  @Column(name = "surname")
  private String surname;
  @NotEmpty
  @Column(name = "email", unique=true)
  private String email;
  @NotEmpty
  @Column(name = "gender")
  private String gender;
  @NotEmpty
  @Column(name = "date")
  private String date;
  @Column(name = "ha" , table = "addresses")
  private String ha;
  @Column(name = "wa" , table = "addresses")
  private String wa;
  

  public void setName(String name) { this.name = name;}
  public void setSurname(String surname) { this.surname=surname;}
  public void setEmail(String email) { this.email = email;}
  public void setGender(String gender) { this.gender=gender;}
  public void setDate(String date) { this.date=date;}
  public void setha(String ha) { this.ha=ha;}
  public void setwa(String wa) { this.wa=wa;}
 
  public Integer getid() { return id;}
  public String getName() { return name;}
  public String getSurname() { return surname;}
  public String getEmail() { return email;}
  public String getGender() { return gender;}
  public String getDate() { return date;}
  public String getha() { return ha;}
  public String getwa() { return wa;}

}