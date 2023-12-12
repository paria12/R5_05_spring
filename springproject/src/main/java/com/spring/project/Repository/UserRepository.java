package com.spring.project.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.project.Model.Article;
import com.spring.project.Model.LikedDisliked;
import com.spring.project.Model.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("FROM LikedDisliked l WHERE l.user.id = :user_id")
    public Iterable<LikedDisliked> findLove(@Param("user_id") int user_id);

    @Query("FROM Article a WHERE a.author.id = :user_id")
    public Iterable<Article> findArticle(@Param("user_id") int user_id);
}
