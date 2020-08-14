package com.telstra.codechallenge.searchrepos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import junit.framework.TestCase;

@TestInstance(Lifecycle.PER_CLASS)
public class SpringBootReposControllerTest extends TestCase {

	@Test
	public void testPositiveController() {
		SpringBootSearchRepoController controller = Mockito.mock(SpringBootSearchRepoController.class);
		SpringBootSearchRepoService service = Mockito.mock(SpringBootSearchRepoService.class);
		controller.springBootSearchService = service;

		List<Repo> reposres = new ArrayList<Repo>();
		Repo repo = new Repo();

		repo.setTotal_count(100);
		reposres.add(repo);
		Mockito.when(service.getRepos()).thenReturn(reposres);

		List<Repo> repos = controller.repos();
		assertNotNull(repos);
	}

	@Test
	public void testNegativeController() {
		SpringBootSearchRepoController controller = Mockito.mock(SpringBootSearchRepoController.class);
		SpringBootSearchRepoService service = Mockito.mock(SpringBootSearchRepoService.class);
		controller.springBootSearchService = service;
		Mockito.when(controller.repos()).thenReturn(null);
		List<Repo> repos = controller.repos();
		assertEquals(repos, null);
	}
}
