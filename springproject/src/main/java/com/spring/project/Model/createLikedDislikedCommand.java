package com.spring.project.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class createLikedDislikedCommand {
    
    private Boolean love;
    private Integer article;
    private Integer user;
}
