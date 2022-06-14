package com.giovanni.learnspring.newsreader.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class Source {

	@Getter
	@Setter
	private String id;

	@Getter
	@Setter
	private String name;

}
