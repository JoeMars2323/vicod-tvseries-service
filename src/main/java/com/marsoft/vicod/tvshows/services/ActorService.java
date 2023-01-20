package com.marsoft.vicod.tvshows.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.rest.ActorRest;

public interface ActorService {
	
	public ActorRest createActor(ConsumerRecord<String, String> consumerRecord) throws VicodException;

}
