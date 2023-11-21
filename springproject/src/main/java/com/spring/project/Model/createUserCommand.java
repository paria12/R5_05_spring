package com.spring.project.Model;

import com.spring.project.Model.User.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class createUserCommand {
    private String name;
    private String password;
    private Role role;

    
}
