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
import com.marsoft.vicod.tvshows.rest.SeasonRest;
import com.marsoft.vicod.tvshows.rest.VicodRestResponse;
import com.marsoft.vicod.tvshows.services.SeasonService;
import com.marsoft.vicod.tvshows.utils.RestConstants;


@RestController
@RequestMapping(RestConstants.SEASONS)
public class SeasonController {

	@Autowired
	private SeasonService seasonService;
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = RestConstants.SEASON_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<SeasonRest> getSeasionyId(@PathVariable Long id) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				seasonService.getSeasonById(id));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<List<SeasonRest>> getAllSeasons() throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				seasonService.getAllSeasons());
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<SeasonRest> createSeason( 
		@RequestBody SeasonRest seasonRest) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				seasonService.createSeason(seasonRest));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value =  RestConstants.SEASON, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<SeasonRest> updateSeason( 
		@RequestBody SeasonRest seasonRest) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				seasonService.updateSeason(seasonRest));
	}
	
	
	
	@ResponseStatus(HttpStatus.OK)
	@PatchMapping(value =  RestConstants.SEASON_NAME, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<SeasonRest> updateSeasonName( 
		@PathVariable Long id, @RequestBody SeasonRest seasonRest) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				seasonService.updateSeasonName(id, seasonRest));
	}
	
	

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = RestConstants.SEASON_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	public VicodRestResponse<SeasonRest> deleteSeason(@PathVariable Long id) throws VicodException {
		return new VicodRestResponse<>(RestConstants.SUCCESS, String.valueOf(HttpStatus.OK), RestConstants.OK,
				seasonService.deleteSeason(id));
	}

	
	
}
