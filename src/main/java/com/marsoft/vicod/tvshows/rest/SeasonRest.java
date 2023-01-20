package com.marsoft.vicod.tvshows.rest;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeasonRest implements Serializable {

	private static final long serialVersionUID = 180802329613616000L;

	private Long seasonId;
	private String seasonName;
	private short seasonNumber;
	//private TvshowRest tvshow;
	
	
	
	public Long getSeasonId() {
		return seasonId;
	}
	
	public void setSeasonId(Long seasonId) {
		this.seasonId = seasonId;
	}
	
	public String getSeasonName() {
		return seasonName;
	}
	
	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}
	
	public short getSeasonNumber() {
		return seasonNumber;
	}
	
	public void setSeasonNumber(short seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
	
	

}