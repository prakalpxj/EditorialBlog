package com.deutsche.EditorialBlog.controller;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deutsche.EditorialBlog.DAO.ArticleDAO;
import com.deutsche.EditorialBlog.bean.ArticleReview;
import com.deutsche.EditorialBlog.bean.Articles;
import com.deutsche.EditorialBlog.model.ArticleReviewModel;
import com.deutsche.EditorialBlog.model.ArticlesModel;
import com.deutsche.EditorialBlog.repository.ArticleReviewRepository;
import com.deutsche.EditorialBlog.repository.ArticlesRepository;
@RestController
@RequestMapping("/EditorialBlog")

public class ArticlesController {
	
	@Autowired 
	ArticlesRepository articlesRepository;
	@Autowired
	ArticleReviewRepository articleReviewRepository;
	@Autowired
	ArticleDAO articleDAO;
	
	@GetMapping("allArticles")
	public ResponseEntity<List<ArticlesModel>> showAllArticles(){
		List<ArticlesModel> list = articlesRepository.findAll();
		
			
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("articleForReview")
	public ArticleReviewModel saveArticleForReview(@RequestBody ArticleReviewModel articleReviewModel){
		
		
		return articleReviewRepository.save(articleReviewModel);
	}
	
	@PostMapping("saveReviewedArticle")
	public ArticleReviewModel saveReviewedArticle(@RequestBody ArticleReviewModel articleReviewModel){
		
		
		ArticlesModel existingModel = articleDAO.articleExists(articleReviewModel.getArticleid(), articleReviewModel.getTitle());
		
		if(existingModel != null) {
			System.out.println("Here Updating");
			existingModel.setContent(articleReviewModel.getContent());
			articlesRepository.save(existingModel);
			
			
		}
		else {
			ArticlesModel newArticle = new ArticlesModel();
			newArticle.setAuthorname(articleReviewModel.getAuthorname());
			newArticle.setArticleid(articleReviewModel.getArticleid());
			newArticle.setTitle(articleReviewModel.getTitle());
			newArticle.setContent(articleReviewModel.getContent());
			newArticle.setArticleid(articleReviewModel.getArticleid());
			
			articlesRepository.save(newArticle);
			System.out.println("Here new entry");
		}
			
		
		
		return null;
	}
	
}






