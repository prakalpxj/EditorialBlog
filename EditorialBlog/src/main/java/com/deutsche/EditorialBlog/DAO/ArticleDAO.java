package com.deutsche.EditorialBlog.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.deutsche.EditorialBlog.model.ArticleReviewModel;
import com.deutsche.EditorialBlog.model.ArticlesModel;


@RepositoryDefinition(idClass = Integer.class, domainClass = ArticlesModel.class)
public interface ArticleDAO {
	@Query("select c  from ArticlesModel c where c.articleid=?1 and c.title=?2")
	public ArticlesModel articleExists(Integer articleId , String title);
	
	/**
	@Query("select c  from UsersModel c where c.answer=?1 and c.email=?2 and c.password = ?3")
	public UsersModel twoFactor(String answer, String username, String password);
	*/
}


