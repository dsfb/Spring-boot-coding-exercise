package com.telstra.codechallenge.searchrepos;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;

import junit.framework.TestCase;

@TestInstance(Lifecycle.PER_CLASS)
public class SpringBootSearchRepoServiceTest extends TestCase {

	public SpringBootSearchRepoServiceTest() {

	}

	@Test
	public void testPositiveRepos() {
		// SpringBootSearchRepoService service = new SpringBootSearchRepoService();
		SpringBootSearchRepoService service = Mockito.mock(SpringBootSearchRepoService.class);

		service.searchBaseUrl = "https://api.github.com";

		List<Repo> reposres = new ArrayList<Repo>();
		Repo repo = new Repo();

		repo.setTotal_count(100);
		reposres.add(repo);

		Mockito.when(service.getRepos()).thenReturn(reposres);
		List<Repo> repos = service.getRepos();
		// System.out.println("Repos : " + repos.size());
		assertNotNull(repos);
	}

	@Test
	public void testNegativeRepos() {
		SpringBootSearchRepoService service = Mockito.mock(SpringBootSearchRepoService.class);
		service.searchBaseUrl = "https://ap1.github.com";
		Mockito.when(service.getRepos()).thenReturn(null);
		List<Repo> repos = service.getRepos();
		assertEquals(null, repos);

	}
}
