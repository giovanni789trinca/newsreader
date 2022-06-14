package com.giovanni.learnspring.newsreader.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class News {

	@Getter
	@Setter
	private String status;

	@Getter
	@Setter
	private Integer totalResults;

	@Getter
	@Setter
	private List<Article> articles;

	@Override
	public String toString() {
		return "Articles{articles='" + articles + '\'' +

				'}';
	}

}
