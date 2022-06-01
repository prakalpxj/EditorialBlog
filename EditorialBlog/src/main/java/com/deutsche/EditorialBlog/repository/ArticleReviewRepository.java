package com.deutsche.EditorialBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deutsche.EditorialBlog.model.ArticleReviewModel;

public interface ArticleReviewRepository extends JpaRepository<ArticleReviewModel, Integer> {

}
