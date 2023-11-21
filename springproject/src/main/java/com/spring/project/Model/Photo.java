package com.spring.project.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "photo")
@NoArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    private Long id;
    private String url_small;
    private String url_medium;
    private String url_large;


    @OneToOne(mappedBy = "photo")
    private Book book;
}
