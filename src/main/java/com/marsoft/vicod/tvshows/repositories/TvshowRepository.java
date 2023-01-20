package com.marsoft.vicod.tvshows.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marsoft.vicod.tvshows.entities.Tvshow;


public interface TvshowRepository extends JpaRepository<Tvshow, Long> {

}
