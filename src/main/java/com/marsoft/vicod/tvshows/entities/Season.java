package com.marsoft.vicod.tvshows.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "season")
public class Season {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="season_id")
	private Long seasonId;

	@Column(name = "season_name", nullable = false)
	private String seasonName;
	
	@Column(name = "season_number", nullable = false)
	private short seasonNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tvshow_id", nullable = false)
	private Tvshow tvshow;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "season")
	private List<Chapter> chapters;

	
	 
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

	public Tvshow getTvshow() {
		return tvshow;
	}

	public void setTvshow(Tvshow tvshow) {
		this.tvshow = tvshow;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	
	
	
}