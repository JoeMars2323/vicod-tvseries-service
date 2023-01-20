package com.marsoft.vicod.tvshows.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marsoft.vicod.tvshows.entities.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
	
	public List<Chapter> getChapterBySeason(Long seasonId);

}
