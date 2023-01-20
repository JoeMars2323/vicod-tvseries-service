-- create tvshow
create table if not exists `tvshow`
(
  `tvshow_id`          	    bigint(20) not null auto_increment,
  `tvshow_name` 			varchar(250) not null,
  `tvshow_description` 		varchar(2050),
  `recommended_age`         tinyint,
  primary key (`tvshow_id`)
);

-- create season
create table if not exists `season`
(
  `season_id`           bigint(20) not null auto_increment,
  `season_name` 		varchar(250) not null,
  `season_number` 	    tinyint not null,
  `tvshow_id`           bigint(20) not null,
  primary key (`season_id`),
  constraint `fk_season_tvshow_id` foreign key (tvshow_id) references `tvshow` (tvshow_id)
);

-- create chapter
create table if not exists `chapter`
(
  `chapter_id`          bigint(20) not null auto_increment,
  `chapter_name` 		varchar(250) not null,
  `chapter_number` 		tinyint not null,
  `chapter_resume` 		varchar(2050),
  `chapter_duration` 	tinyint,
  `chapter_date` 		date,
  `season_id`           bigint(20) not null,
  primary key (`chapter_id`),
  constraint `fk_chapter_season_id` foreign key (season_id) references `season` (season_id)
);