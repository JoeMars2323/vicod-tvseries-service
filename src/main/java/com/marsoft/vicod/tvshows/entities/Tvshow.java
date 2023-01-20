package com.marsoft.vicod.tvshows.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tvshow")
public class Tvshow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tvshow_id")
	private Long tvshowId;

	@Column(name = "tvshow_name", nullable = false)
	private String tvshowName;

	@Column(name = "tvshow_description")
	private String tvshowDescription;

	@Column(name = "recommended_age")
	private byte recommendedAge;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tvshow")
	private List<Season> seasons;

	
	
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

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}
	
	
	
}