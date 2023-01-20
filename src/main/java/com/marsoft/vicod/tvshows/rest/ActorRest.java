package com.marsoft.vicod.tvshows.rest;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorRest implements Serializable {
	
	private static final long serialVersionUID = -7785996274072846906L;
	
	private String name;
	private String country;
	private Date birthday;
	
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	

	@Override
	public String toString() {
		return "ActorConsumerRest [name=" + name + ", country=" + country + ", birthday=" + birthday + "]";
	}
	

	
}