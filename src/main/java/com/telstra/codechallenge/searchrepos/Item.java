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

public class Item {
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public HtmlUrl getHtml_url() {
		return html_url;
	}

	public void setHtml_url(HtmlUrl html_url) {
		this.html_url = html_url;
	}

	private Name name;
	private HtmlUrl html_url;
}
