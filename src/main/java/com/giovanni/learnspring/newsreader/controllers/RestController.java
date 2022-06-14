package com.giovanni.learnspring.newsreader.controllers;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.giovanni.learnspring.newsreader.daos.ArticleDao;
import com.giovanni.learnspring.newsreader.entity.Article;
import com.giovanni.learnspring.newsreader.entity.News;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	private ArticleDao articleDao;

	private final RestTemplate restTemplate;

	private final ObjectMapper objectMapper;

	public RestController(RestTemplateBuilder rTB, ObjectMapper objM, ArticleDao aD) {
		this.restTemplate = rTB.build();
		this.objectMapper = objM;
		this.articleDao = aD;
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello to everyone!!!";
	}

	@GetMapping("/test")
	public News testNewsApi() throws JsonMappingException, JsonProcessingException {
		String result = this.restTemplate.getForObject(
				"https://newsapi.org/v2/everything?q=tesla&from=2022-05-14&sortBy=publishedAt&apiKey=3ccbcf09d7464c70b9d207c55b12c10c",
				String.class);
		News news = objectMapper.readValue(result, News.class);
		System.out.println(news.getArticles());

		for (Article var : news.getArticles()) {
			Article article = articleDao.findByTitle(var.getTitle());
			if (article != null) {
				continue;
			}
			articleDao.save(new Article(var.getArticleId(), var.getAuthor(), var.getTitle(), var.getDescription(),
					var.getUrl(), var.getUrlToImage(), var.getPublishedAt(), var.getContent()));
		}

		return news;
	}

}
