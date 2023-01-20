package com.marsoft.vicod.tvshows.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marsoft.vicod.tvshows.entities.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {
	

}
