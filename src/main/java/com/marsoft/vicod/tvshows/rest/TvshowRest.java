package com.marsoft.vicod.tvshows.rest;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TvshowRest implements Serializable {
	
	private static final long serialVersionUID = 4916713904971425156L;

	private Long tvshowId;
	private String tvshowName;
	private String tvshowDescription;
	private byte recommendedAge;
	private List<SeasonRest> seasons;
	
	
	
	public Long getTvshowId() {
		return tvshowId;
	}
	public void setTvshowId(Long tvshowId) {
		this.tvshowId = tvshowId;
	}
	public String getTvshowName() {
		return tvshowName;
	}
	public void setTvshowName(String tvshowName) {
		this.tvshowName = tvshowName;
	}
	public String getTvshowDescription() {
		return tvshowDescription;
	}
	public void setTvshowDescription(String tvshowDescription) {
		this.tvshowDescription = tvshowDescription;
	}
	public byte getRecommendedAge() {
		return recommendedAge;
	}
	public void setRecommendedAge(byte recommendedAge) {
		this.recommendedAge = recommendedAge;
	}
	public List<SeasonRest> getSeasons() {
		return seasons;
	}
	public void setSeasons(List<SeasonRest> seasons) {
		this.seasons = seasons;
	}
	
	
	
	@Override
	public String toString() {
		return "TvshowRest [tvshowId=" + tvshowId + ", tvshowName=" + tvshowName + ", tvshowDescription="
				+ tvshowDescription + ", recommendedAge=" + recommendedAge + ", seasons=" + seasons + "]";
	}
	
	

}