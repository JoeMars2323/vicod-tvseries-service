package com.marsoft.vicod.tvshows.services;

import java.util.List;

import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.rest.ChapterRest;


public interface ChapterService {

	public List<ChapterRest> getChapterBySeason(Long seasonId) throws VicodException;
	
	public ChapterRest updateChaptersName(Long chapterId, ChapterRest chapterRest) throws VicodException;

	public List<ChapterRest> getAllChapters() throws VicodException;

	public ChapterRest createChapter(ChapterRest chapterRest) throws VicodException;

	public ChapterRest updateChapter(ChapterRest chapterRest) throws VicodException;

	public ChapterRest deleteChapter(Long id) throws VicodException;

}
