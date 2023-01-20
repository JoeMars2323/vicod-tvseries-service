package com.marsoft.vicod.tvshows.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.rest.ChapterRest;
import com.marsoft.vicod.tvshows.rest.VicodRestResponse;
import com.marsoft.vicod.tvshows.services.ChapterService;
import com.marsoft.vicod.tvshows.utils.RestConstants;


@RestController
@RequestMapping(RestConstants.CHAPTERS)
public class ChapterController {

	@Autowired
	private ChapterService chapterService;

	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.CHAPTER_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<List<ChapterRest>> getChapterBySeason(
			@PathVariable Long id) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				chapterService.getChapterBySeason(id));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<List<ChapterRest>> getAllChapters() throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				chapterService.getAllChapters());
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<ChapterRest> createChapter( 
		@RequestBody ChapterRest chapterRest) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				chapterService.createChapter(chapterRest));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value =  RestConstants.CHAPTER, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<ChapterRest> updateChapter( 
		@RequestBody ChapterRest chapterRest) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				chapterService.updateChapter(chapterRest));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@PatchMapping(value = RestConstants.CHAPTER_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<ChapterRest> updateChapterName(
		@PathVariable Long id, @RequestBody ChapterRest chapterRest) throws VicodException {
		return new VicodRestResponse<ChapterRest>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				chapterService.updateChaptersName(id, chapterRest));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = RestConstants.CHAPTER_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<ChapterRest> deleteChaoter(@PathVariable Long id) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				chapterService.deleteChapter(id));
	}
	
	
	
}