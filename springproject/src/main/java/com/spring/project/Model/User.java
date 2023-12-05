package com.spring.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String password;

  public enum Role{moderator,publisher,non_authentified};
  private Role role;
}
