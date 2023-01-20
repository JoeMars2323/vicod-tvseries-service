package com.marsoft.vicod.tvshows.services;

import java.util.List;

import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.rest.SeasonRest;


public interface SeasonService {
	
	public SeasonRest getSeasonById(Long id) throws VicodException;
	
	public List<SeasonRest> getAllSeasons() throws VicodException;
	
    public SeasonRest createSeason(SeasonRest seasonRest) throws VicodException;
	
    public SeasonRest updateSeason(SeasonRest seasonRest) throws VicodException;
	
    public SeasonRest updateSeasonName(Long id, SeasonRest seasonRest) throws VicodException;
	
	public SeasonRest deleteSeason(Long id) throws VicodException;
}
	