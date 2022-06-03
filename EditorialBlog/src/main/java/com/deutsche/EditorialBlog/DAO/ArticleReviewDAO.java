package com.deutsche.EditorialBlog.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.deutsche.EditorialBlog.model.ArticleReviewModel;
import com.deutsche.EditorialBlog.model.ArticlesModel;

@RepositoryDefinition(idClass = Integer.class, domainClass = ArticleReviewModel.class)
public interface ArticleReviewDAO {
	
	@Query("select c from ArticleReviewModel c where c.articleid=?1 and c.title=?2")
	public ArticleReviewModel deleteReviewedArticle(Integer articleId , String title);
	
}
