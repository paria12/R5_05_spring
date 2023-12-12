package com.spring.project.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.project.Model.Article;
import com.spring.project.Model.LikedDisliked;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    @Query("FROM LikedDisliked l WHERE l.article.id = :article_id")
    public Iterable<LikedDisliked> findLove(@Param("article_id") int article_id);
}
