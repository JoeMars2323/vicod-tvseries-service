package com.marsoft.vicod.tvshows.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marsoft.vicod.tvshows.entities.Chapter;
import com.marsoft.vicod.tvshows.exceptions.NotFoundException;
import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.repositories.ChapterRepository;
import com.marsoft.vicod.tvshows.rest.ChapterRest;
import com.marsoft.vicod.tvshows.utils.ExceptionConstants;
import com.marsoft.vicod.tvshows.utils.LogConstants;


@Service
public class ChapterServiceImpl implements ChapterService {
	
	private Logger log = LoggerFactory.getLogger(SeasonServiceImpl.class);

	private ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private ChapterRepository chapterRepository;
	
	
	
	@Override
	@Transactional
	public List<ChapterRest> getChapterBySeason(Long seasonId) throws VicodException {
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		List<ChapterRest> chapterResponseList = null;
		try {
			List<Chapter> chapterList = chapterRepository.findAll()
					.stream().filter(chapter -> chapter.getSeason()
							.getSeasonId().equals(seasonId)).collect(Collectors.toList());
			chapterResponseList = chapterList.stream().map(chapter 
					-> modelMapper.map(chapter, ChapterRest.class)).collect(Collectors.toList());
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(chapterResponseList.toString());
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		return chapterResponseList;
	}



	@Override
	@Transactional
	public List<ChapterRest> getAllChapters() throws VicodException {
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		List<ChapterRest> chapterResponseList = null;
		try {
			chapterResponseList = chapterRepository.findAll().stream().map(chapter -> 
			modelMapper.map(chapter, ChapterRest.class)).collect(Collectors.toList());
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(chapterResponseList.toString());
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		return chapterResponseList;
	}



	@Override
	@Transactional
	public ChapterRest createChapter(ChapterRest chapterRest) throws VicodException {
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		ChapterRest chapterResponse = null;
		try {
			Chapter chapter = modelMapper.map(chapterRest, Chapter.class);
			chapterResponse = modelMapper.map(chapterRepository.save(chapter), ChapterRest.class);
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(chapterResponse.toString());
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
        return chapterResponse;
	}



	@Override
	@Transactional
	public ChapterRest updateChapter(ChapterRest chapterRest) throws VicodException {
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		ChapterRest chapterResponse = null;
		try {
			if(chapterRest.getChapterId() != null) {
				Chapter chapter = null;
				chapter = modelMapper.map(chapterRest, Chapter.class);
				chapter = chapterRepository.save(chapter);
				chapterResponse = modelMapper.map(chapter, ChapterRest.class);
	        } else {
	        	throw new NotFoundException(ExceptionConstants.TV_SHOW_NOT_FOUND);
	        }
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(chapterResponse.toString());
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
        return chapterResponse;
	}
	
	
	
	@Override
	@Transactional
    public ChapterRest updateChaptersName(Long chapterId, ChapterRest chapterRest) 
    		throws VicodException {
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		ChapterRest chapterResponse = null;
		try {
			Chapter chapter = null;
	        chapter = chapterRepository.getReferenceById(chapterId);
	        chapter.setChapterName(chapterRest.getChapterName());
	        chapter = chapterRepository.save(chapter);
	        chapterResponse = modelMapper.map(chapter, ChapterRest.class);
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(chapterResponse.toString());
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
        return chapterResponse;
    }



	@Override
	@Transactional
	public ChapterRest deleteChapter(Long id) throws VicodException {
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		ChapterRest chapterResponse = null;
		try {
			Chapter chapter  = chapterRepository.getReferenceById(id);
			chapterRepository.delete(chapter);
			chapterResponse = modelMapper.map(chapter, ChapterRest.class);
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new NotFoundException(e.getMessage());
		}
		log.info(chapterResponse.toString());
		log.info(LogConstants.GET_SEASON_ID_BEGIN);
		return chapterResponse;
	}
	
	

}