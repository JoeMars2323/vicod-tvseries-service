package com.marsoft.vicod.tvshows.services;

import javax.transaction.Transactional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.marsoft.vicod.tvshows.entities.Actor;
import com.marsoft.vicod.tvshows.exceptions.InternalServerErrorException;
import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.repositories.ActorRepository;
import com.marsoft.vicod.tvshows.rest.ActorRest;
import com.marsoft.vicod.tvshows.utils.LogConstants;


@Service
public class ActorServiceImpl implements ActorService {
	
	private Logger log = LoggerFactory.getLogger(ActorServiceImpl.class);
	
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private ActorRepository actorRepository;
	
	
	
	@Override
	@Transactional
	public ActorRest createActor(ConsumerRecord<String, String> consumerRecord) throws VicodException {
		log.info(LogConstants.GET_TVSHOW_ID_MESSAGE_BEGIN);
		ActorRest actorResponse = null;
		try {
			Gson gson = new Gson();
	        JsonObject object = (JsonObject) JsonParser.parseString(consumerRecord.value());
	        ActorRest actorRest = gson.fromJson(object, ActorRest.class);
	        Actor actor = actorRepository.save(mapper.map(actorRest, Actor.class));
	        actorResponse = mapper.map(actor, ActorRest.class);
		} catch(Exception e) {
			log.error(e.getMessage());
			throw new InternalServerErrorException(e.getMessage());
		}
        log.info(actorResponse.toString());
        log.info(LogConstants.GET_TVSHOW_ID_MESSAGE_BEGIN);
        return actorResponse;
	}

	
	
}