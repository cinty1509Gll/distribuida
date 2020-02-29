package com.distribuida.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class TodosDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private Integer id;
	@Getter @Setter private Integer userid;
	@Getter @Setter private String title;
	@Getter @Setter private Boolean completed;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	  
	
}
