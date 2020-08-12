/**
 * 
 */
package com.telstra.codechallenge.searchrepos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author GURU
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Repo {
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	
	public boolean isIncomplete_results() {
		return incomplete_results;
	}
	public void setIncomplete_results(boolean incomplete_results) {
		this.incomplete_results = incomplete_results;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	private int total_count;
	private boolean incomplete_results;
	private List<Item> items;
}
