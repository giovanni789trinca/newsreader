package com.giovanni.learnspring.newsreader.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articles")
public class Article {

	@Id
	@Column(name = "ARTICLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer articleId;

//	@Column(name = "SOURCE")
//	@Getter
//	@Setter
//	private Map<String, Source> source;

	@Column(name = "AUTHOR")
	@Getter
	@Setter
	private String author;

	@Column(name = "TITLE")
	@Getter
	@Setter
	private String title;

	@Column(name = "DESCRIPTION")
	@Getter
	@Setter
	private String description;

	@Column(name = "URL")
	@Getter
	@Setter
	private String url;

	@Column(name = "URL_TO_IMAGE")
	@Getter
	@Setter
	private String urlToImage;

	@Column(name = "PUBLISHED_AT")
	@Getter
	@Setter
	private String publishedAt;

	@Column(name = "CONTENT")
	@Getter
	@Setter
	private String content;

	@Override
	public String toString() {
		return "Article{" + "articleId=" + articleId + ", author='" + author + '\'' + ", title='" + title + '\''
				+ ", description='" + description + '\'' + ", url=" + url + ", urlToImage=" + urlToImage
				+ ", publishedAt=" + publishedAt + ", content=" + content +

				'}';
	}

}
