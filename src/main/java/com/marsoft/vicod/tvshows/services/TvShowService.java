package com.marsoft.vicod.tvshows.services;

import java.util.List;

import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.rest.TvshowRest;


public interface TvShowService {

	public TvshowRest getTvshowById(Long id) throws VicodException;
	
	public List<TvshowRest> getAllTvshows() throws VicodException;
	
	public TvshowRest createTvshow(TvshowRest tvShowRest) throws VicodException;
	
	public TvshowRest updateTvshow(TvshowRest tvShowRest) throws VicodException;
	
	public TvshowRest updateTvshowName(Long tvShowId, TvshowRest tvShowRest) throws VicodException;
	
	public TvshowRest deleteTvshow(Long id) throws VicodException;
	
	

}