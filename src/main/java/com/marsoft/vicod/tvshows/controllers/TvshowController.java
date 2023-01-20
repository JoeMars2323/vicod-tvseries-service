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
import com.marsoft.vicod.tvshows.rest.TvshowRest;
import com.marsoft.vicod.tvshows.rest.VicodRestResponse;
import com.marsoft.vicod.tvshows.services.TvShowService;
import com.marsoft.vicod.tvshows.utils.RestConstants;


@RestController
@RequestMapping(RestConstants.TV_SHOWS)
public class TvshowController {

	@Autowired
	private TvShowService tvShowService;
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.TV_SHOW_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<TvshowRest> getTvshowById(@PathVariable Long id) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				tvShowService.getTvshowById(id));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<List<TvshowRest>> getAllTvshows() throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				tvShowService.getAllTvshows());
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<TvshowRest> createTvshow( 
		@RequestBody TvshowRest tvShowRest) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				tvShowService.createTvshow(tvShowRest));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value =  RestConstants.TV_SHOW, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<TvshowRest> updateTvshow( 
		@RequestBody TvshowRest tvShowRest) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				tvShowService.updateTvshow(tvShowRest));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@PatchMapping(value =  RestConstants.TV_SHOW_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<TvshowRest> updateTvshowName( 
		@PathVariable Long id, @RequestBody TvshowRest tvShowRest) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				tvShowService.updateTvshowName(id, tvShowRest));
	}
	
	

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = RestConstants.TV_SHOW_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<TvshowRest> deleteTvshow(@PathVariable Long id) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				tvShowService.deleteTvshow(id));
	}
	
	
	
}