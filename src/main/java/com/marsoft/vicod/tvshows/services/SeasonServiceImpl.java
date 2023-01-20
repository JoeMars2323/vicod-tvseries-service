package com.marsoft.vicod.tvshows.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marsoft.vicod.tvshows.entities.Season;
import com.marsoft.vicod.tvshows.exceptions.NotFoundException;
import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.repositories.SeasonRepository;
import com.marsoft.vicod.tvshows.rest.SeasonRest;
import com.marsoft.vicod.tvshows.utils.ExceptionConstants;
import com.marsoft.vicod.tvshows.utils.LogConstants;


@Service
public class SeasonServiceImpl implements SeasonService {
	
	private Logger log = LoggerFactory.getLogger(SeasonServiceImpl.class);
	
	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private SeasonRepository seasonRepository;
	
	
	
	@Override
	@Transactional
	public SeasonRest getSeasonById(Long id) throws VicodException {
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		SeasonRest seasonResponse = null;
		try {
			seasonResponse = modelMapper.map(seasonRepository.getReferenceById(id), SeasonRest.class);
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(seasonResponse.toString());
		log.info(LogConstants.GET_SEASON_ID_END);
		return seasonResponse;
	}
	
	
	
	@Override
	@Transactional
	public List<SeasonRest> getAllSeasons() throws VicodException {
		log.info(LogConstants.GET_ALL_SEASONS_BEGIN);
		List<SeasonRest> seasonResponseList = null;
		try {
			seasonResponseList = seasonRepository.findAll().stream().map(tvshow -> 
				modelMapper.map(tvshow, SeasonRest.class)).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(seasonResponseList.toString());
		log.info(LogConstants.GET_ALL_SEASONS_END);
		return seasonResponseList;
	}
	
	
	
	@Override
	@Transactional
    public SeasonRest createSeason(SeasonRest seasonRest) throws VicodException {
		SeasonRest seasonResponse = null;
		log.info(LogConstants.CREATE_SEASON_BEGIN);
		try {
			Season season = modelMapper.map(seasonRest, Season.class);
			seasonResponse = modelMapper.map(seasonRepository.save(season), SeasonRest.class);
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(seasonResponse.toString());
		log.info(LogConstants.CREATE_SEASON_END);
        return seasonResponse;
    }
	
	
	
	@Override
	@Transactional
    public SeasonRest updateSeason(SeasonRest seasonRest) throws VicodException {
		log.info(LogConstants.UPDATE_SEASON_BEGIN);
		SeasonRest seasonResponse = null;
		try {
			Season season = null;
			if(seasonRest.getSeasonId() != null) {
				season = modelMapper.map(seasonRest, Season.class);
	        	season = seasonRepository.save(season);
	        	seasonResponse = modelMapper.map(season, SeasonRest.class);
	        } else {
	        	throw new NotFoundException(ExceptionConstants.TV_SHOW_NOT_FOUND);
	        }
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(seasonResponse.toString());
		log.info(LogConstants.UPDATE_SEASON_END);
        return seasonResponse;
    }
	
	

	@Override
	@Transactional
    public SeasonRest updateSeasonName(Long id, SeasonRest seasonRest) throws VicodException {
		log.info(LogConstants.UPDATE_SEASON_NAME_BEGIN);
		SeasonRest seasonResponse = null;
		try {
			Season tvshow = seasonRepository.getReferenceById(id);
	        tvshow.setSeasonName(seasonRest.getSeasonName());
	        tvshow = seasonRepository.save(tvshow);
			seasonResponse = modelMapper.map(tvshow, SeasonRest.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(seasonResponse.toString());
		log.info(LogConstants.UPDATE_SEASON_NAME_END);
        return seasonResponse;
    }
	
	
	
	@Override
	@Transactional
	public SeasonRest deleteSeason(Long id) throws VicodException {
		log.info(LogConstants.DELETE_SEASON_BEGIN);
		SeasonRest seasonResponse = null;
		try {
			Season tvshow  = seasonRepository.getReferenceById(id);
			seasonRepository.delete(tvshow);
			seasonResponse =  modelMapper.map(tvshow, SeasonRest.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(seasonResponse.toString());
		log.info(LogConstants.DELETE_SEASON_END);
		return seasonResponse;
	}

	

}