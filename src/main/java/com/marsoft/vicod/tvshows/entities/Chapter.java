package com.marsoft.vicod.tvshows.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "chapter")
public class Chapter{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="chapter_id")
	private Long chapterId;

	@Column(name = "chapter_name", nullable = false)
	private String chapterName;
	
	@Column(name = "chapter_number", nullable = false)
	private short chapterNumber;
	
	@Column(name = "chapter_resume")
	private String chapterResume;

	@Column(name = "duration")
	private short chapterDuration;
	
	@Column(name = "chapter_date")
	private short chapterDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "season_id", nullable = false)
	private Season season;
	
	

	public Long getChapterId() {
		return chapterId;
	}

	public void setChapterId(Long chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public short getChapterNumber() {
		return chapterNumber;
	}

	public void setChapterNumber(short chapterNumber) {
		this.chapterNumber = chapterNumber;
	}

	public String getChapterResume() {
		return chapterResume;
	}

	public void setChapterResume(String chapterResume) {
		this.chapterResume = chapterResume;
	}

	public short getChapterDuration() {
		return chapterDuration;
	}

	public void setChapterDuration(short chapterDuration) {
		this.chapterDuration = chapterDuration;
	}

	public short getChapterDate() {
		return chapterDate;
	}

	public void setChapterDate(short chapterDate) {
		this.chapterDate = chapterDate;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	
	
}