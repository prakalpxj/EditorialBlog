package com.deutsche.EditorialBlog.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deutsche.EditorialBlog.model.UsersModel;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel,Integer> {
	

}
