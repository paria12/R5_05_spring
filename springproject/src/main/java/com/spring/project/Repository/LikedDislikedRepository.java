package com.spring.project.Repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.project.Model.LikedDisliked;

public interface LikedDislikedRepository extends CrudRepository<LikedDisliked, Integer> {
}
