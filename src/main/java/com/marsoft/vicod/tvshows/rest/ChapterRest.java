package com.marsoft.vicod.tvshows.rest;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChapterRest implements Serializable {

	private static final long serialVersionUID = 8725949484031409482L;

	private Long chapterId;
	private String chapterName;
	private short chapterNumber;
	private String chapterResume;
	private short chapterDuration;
	private short chapterDate;
	
	
	
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
	
	
	
	@Override
	public String toString() {
		return "ChapterRest [chapterId=" + chapterId + ", chapterName=" + chapterName + ", chapterNumber="
				+ chapterNumber + ", chapterResume=" + chapterResume + ", chapterDuration=" + chapterDuration
				+ ", chapterDate=" + chapterDate + "]";
	}
	
	

}