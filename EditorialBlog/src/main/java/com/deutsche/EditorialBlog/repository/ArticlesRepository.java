package com.deutsche.EditorialBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deutsche.EditorialBlog.model.ArticlesModel;


public interface ArticlesRepository extends JpaRepository<ArticlesModel,Integer> {

}
