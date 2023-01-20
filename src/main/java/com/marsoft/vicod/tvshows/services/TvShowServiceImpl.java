package com.marsoft.vicod.tvshows.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marsoft.vicod.tvshows.entities.Tvshow;
import com.marsoft.vicod.tvshows.exceptions.InternalServerErrorException;
import com.marsoft.vicod.tvshows.exceptions.NotFoundException;
import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.repositories.TvshowRepository;
import com.marsoft.vicod.tvshows.rest.TvshowRest;
import com.marsoft.vicod.tvshows.utils.ExceptionConstants;
import com.marsoft.vicod.tvshows.utils.LogConstants;


@Service
public class TvShowServiceImpl implements TvShowService {

	private Logger log = LoggerFactory.getLogger(TvShowServiceImpl.class);
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private TvshowRepository tvshowRepository;
	
	
	
	@Override
	@Transactional
	public TvshowRest getTvshowById(Long id) throws VicodException {
		log.info(LogConstants.GET_TVSHOW_ID_MESSAGE_BEGIN);
		TvshowRest tvshowResponse = null;
		try {
			Tvshow tvshow = tvshowRepository.getReferenceById(id);
			tvshowResponse = modelMapper.map(tvshow, TvshowRest.class);
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		} 
		log.info(tvshowResponse.toString());
		log.info(LogConstants.GET_TVSHOW_ID_MESSAGE_END);
		return tvshowResponse;
	}
	
	
	
	@Override
	@Transactional
	public List<TvshowRest> getAllTvshows() throws VicodException {
		log.info(LogConstants.GET_ALL_TVSHOWS_BEGIN);
		List<TvshowRest> tvshowResponseList = null;
		try {
			tvshowResponseList = tvshowRepository.findAll().stream().map(tvshow -> 
			modelMapper.map(tvshow, TvshowRest.class)).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(tvshowResponseList.toString());
		log.info(LogConstants.GET_ALL_TVSHOWS_END);
		return tvshowResponseList;
	}
	
	
	
	@Override
	@Transactional
    public TvshowRest createTvshow(TvshowRest tvshowRest) throws VicodException {
		log.info(LogConstants.CREATE_TVSHOW_BEGIN);
        TvshowRest tvshowResponse = null;
        try {
        	Tvshow tvshow = modelMapper.map(tvshowRest, Tvshow.class);
        	tvshowResponse = modelMapper.map(tvshowRepository.save(tvshow), TvshowRest.class);
        } catch(Exception e) {
        	log.error(e.getMessage());
			throw new InternalServerErrorException(e.getMessage());
        }
        log.info(tvshowResponse.toString());
        log.info(LogConstants.CREATE_TVSHOW_END);
        return tvshowResponse;
    }
	
	
	
	@Override
	@Transactional
    public TvshowRest updateTvshow(TvshowRest tvshowRest) throws VicodException {
		log.info(LogConstants.UPDATE_TVSHOW_BEGIN);
		TvshowRest tvshowResponse = null;
		if(tvshowRest.getTvshowId() != null) {
			try {
				Tvshow tvshow = modelMapper.map(tvshowRest, Tvshow.class);
				tvshow = tvshowRepository.save(tvshow);
				tvshowResponse = modelMapper.map(tvshow, TvshowRest.class);
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new InternalServerErrorException(e.getMessage());
			}
        } else {
        	throw new NotFoundException(ExceptionConstants.TV_SHOW_NOT_FOUND);
        }
		log.info(tvshowResponse.toString());
		log.info(LogConstants.UPDATE_TVSHOW_END);
        return tvshowResponse;
    }
	
	

	@Override
	@Transactional
    public TvshowRest updateTvshowName(Long id, TvshowRest tvshowRest) throws VicodException {
		log.info(LogConstants.UPDATE_TVSHOW_NAME_BEGIN);
		TvshowRest tvshowResponse = null;
		try {
			Tvshow tvshow = tvshowRepository.getReferenceById(id);
	        tvshow.setTvshowName(tvshowRest.getTvshowName());
	        tvshow = tvshowRepository.save(tvshow);
	        tvshowResponse = modelMapper.map(tvshow, TvshowRest.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new InternalServerErrorException(e.getMessage());
		}
		log.info(tvshowResponse.toString());
		log.info(LogConstants.UPDATE_TVSHOW_NAME_END);
        return tvshowResponse;
    }
	
	
	
	@Override
	@Transactional
	public TvshowRest deleteTvshow(Long id) throws VicodException {
		log.info(LogConstants.DELETE_TVSHOW_BEGIN);
		TvshowRest tvshowResponse = null;
		try {
			Tvshow tvshow  = tvshowRepository.getReferenceById(id);
			tvshowRepository.delete(tvshow);
			tvshowResponse = modelMapper.map(tvshow, TvshowRest.class);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new InternalServerErrorException(e.getMessage());
		}
		log.info(tvshowResponse.toString());
		log.info(LogConstants.UPDATE_TVSHOW_NAME_END);
		return tvshowResponse;
	}


	
}