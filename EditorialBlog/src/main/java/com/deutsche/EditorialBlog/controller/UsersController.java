package com.deutsche.EditorialBlog.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deutsche.EditorialBlog.DAO.UsersDAO;
import com.deutsche.EditorialBlog.bean.Users;
import com.deutsche.EditorialBlog.model.UsersModel;
import com.deutsche.EditorialBlog.repository.UsersRepository;
@CrossOrigin
@RestController
@RequestMapping("/EditorialBlog")

public class UsersController {
	
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UsersDAO usersDAO;
	
	
	@PostMapping("signup")
	public UsersModel createUser(@RequestBody UsersModel newUser) {
		
		return this.usersRepository.save(newUser);
	}
	
	
	@GetMapping("login")
	public Users userLogin (@RequestParam("username") String username, @RequestParam("password") String password) {
		Users users  = new Users();
		UsersModel usersModel = usersDAO.userLogin(username, password) ;
		
		if(usersModel!= null) {
			BeanUtils.copyProperties(usersModel, users);
			return users;
			
		}       
		else {
			return null;
	    }
		
	}

	@GetMapping("twoFactor")
	public ResponseEntity<Users> userLogin (@RequestParam("username") String username, @RequestParam("password") String password,@RequestParam("answer") String answer) {
		Users users  = new Users();
		UsersModel usersModel = usersDAO.twoFactor(answer,username,password);
		
		if(usersModel!= null) {
			BeanUtils.copyProperties(usersModel, users);
			return ResponseEntity.ok(users);
			
		}       
		else {
			return ResponseEntity.notFound().build();
	    }
		
	}
	
}
