package com.telstra.codechallenge.searchrepos;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpringBootSearchRepoService {
  Logger logger = LoggerFactory.getLogger(SpringBootSearchRepoService.class);
	
  @Value("${search.base.url}")
  private String searchBaseUrl;

  private RestTemplate restTemplate;

  public SpringBootSearchRepoService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * Returns an array of spring boot quotes. Taken from https://spring.io/guides/gs/consuming-rest/.
   *
   * @return - a quote array
   */
  public List<Repo> getRepos() {
	  logger.info("***Inside SpringBootSearchRepoService - getRepos()");
	  logger.info("**searchBaseUrl = "+searchBaseUrl);
    
	  ResponseEntity<String> res =  restTemplate.exchange(searchBaseUrl + "/search/repositories?q=tetris+language:assembly&sort=stars&order=desc&limit=10",HttpMethod.GET,null, String.class);
	  JSONObject resObj = new JSONObject(res.getBody());
		  JSONArray items =resObj.getJSONArray("items");
		  List<Item> itemList = new ArrayList<>();
          for(int i=0;i<items.length();i++)
          {
        	  
        	  JSONObject item = items.getJSONObject(i);
        	  Name name = new Name();
        	  name.setName(item.optString("name",""));
        	  System.out.println("name : " + name.getName() );
        	  
        	  HtmlUrl url = new HtmlUrl();
        	  url.setHtml_url(item.optString("html_url",""));
        	  url.setLanguage(item.optString("language",""));
        	  System.out.println("language : " + url.getLanguage());
        	  System.out.println("url : " + url.getHtml_url());
        	 // System.out.println("description : " + item.getString("description").toString());
        	  
        	  
        	  url.setDescription(item.optString("description",""));
        	  
        	  url.setWatchers_count(item.getInt("watchers_count"));
        	  
        	  Item item1 = new Item();
        	  item1.setHtml_url(url);
        	  item1.setName(name);
        	  
        	  itemList.add(item1);
             }
    	  Repo repo = new Repo();
		  repo.setIncomplete_results(resObj.getBoolean("incomplete_results"));
		  repo.setTotal_count(resObj.getInt("total_count"));
		  repo.setItems(itemList);
		  
		  List<Repo> repoList= new ArrayList<>();
		  repoList.add(repo);
		  
	 // System.out.println("rsponse : " + resObj.toString());
	  return repoList;
  }
}
 
