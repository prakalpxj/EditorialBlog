package com.deutsche.EditorialBlog.DAO;

import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.deutsche.EditorialBlog.model.UsersModel;

@RepositoryDefinition(idClass = Integer.class, domainClass = UsersModel.class)


public interface UsersDAO {
	@Query("select c  from UsersModel c where c.email=?1 and c.password=?2")
	public UsersModel userLogin(String username , String password);
	
	@Query("select c  from UsersModel c where c.answer=?1 and c.email=?2 and c.password = ?3")
	public UsersModel twoFactor(String answer, String username, String password);
}
