package com.marsoft.vicod.tvshows.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marsoft.vicod.tvshows.entities.Actor;


@Repository
public interface ActorRepository extends JpaRepository<Actor, Long>  {

}
