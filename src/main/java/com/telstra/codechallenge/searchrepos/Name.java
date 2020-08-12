/**
 * 
 */
package com.telstra.codechallenge.searchrepos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author GURU
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class Name {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;
}
