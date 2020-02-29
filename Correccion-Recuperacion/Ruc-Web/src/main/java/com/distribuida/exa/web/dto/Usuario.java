package com.distribuida.exa.web.dto;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Access(value = AccessType.FIELD)
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "addressId")
	private Integer addresId;
	
	@Column(name = "phone")
	private Integer phone;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "companyId")
	private Integer companyId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAddresId() {
		return addresId;
	}

	public void setAddresId(Integer addresId) {
		this.addresId = addresId;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
}
