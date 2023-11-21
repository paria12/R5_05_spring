package com.spring.project.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class createArticleCommand {
    private String author;
    private String content;
    private Date publishDate;

    
}
