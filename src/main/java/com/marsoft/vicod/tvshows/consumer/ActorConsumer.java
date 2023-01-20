package com.marsoft.vicod.tvshows.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.marsoft.vicod.tvshows.exceptions.VicodException;
import com.marsoft.vicod.tvshows.services.ActorService;


@Component
public class ActorConsumer {
	
	Logger log = LoggerFactory.getLogger(ActorConsumer.class);
	
	@Autowired
	private ActorService actorService;
	
	
	
	@KafkaListener(topics = {"actors-topic"}, groupId = "actors-group")
    public void onMessage(ConsumerRecord<String, String> consumerRecord) throws VicodException {
		actorService.createActor(consumerRecord);
    }
	
	

}