package com.telstra.codechallenge.searchrepos;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SpringBootSearchRepoController {
	Logger logger = LoggerFactory.getLogger(SpringBootSearchRepoController.class);

	public SpringBootSearchRepoService springBootSearchService;

	public SpringBootSearchRepoController(SpringBootSearchRepoService springBootSearchService) {
		this.springBootSearchService = springBootSearchService;
	}

	public SpringBootSearchRepoController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return a list of search repositories
	 */
	@RequestMapping(path = "/search/repositories", method = RequestMethod.GET)
	public List<Repo> repos() {
		logger.info("***Inside SpringBootSearchRepoController - repos()");
		return springBootSearchService.getRepos();
	}
}
