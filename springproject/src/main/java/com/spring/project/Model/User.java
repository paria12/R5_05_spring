package com.spring.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String password;

  public enum Role{moderator,publisher,non_authentified};
  private Role role;

  @OneToOne(mappedBy = "article")
    private Article article;
}
