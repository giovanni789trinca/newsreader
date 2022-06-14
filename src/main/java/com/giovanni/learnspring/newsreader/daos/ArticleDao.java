package com.giovanni.learnspring.newsreader.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giovanni.learnspring.newsreader.entity.Article;

public interface ArticleDao extends JpaRepository<Article, Integer> {

	Article findByTitle(String title);

}
