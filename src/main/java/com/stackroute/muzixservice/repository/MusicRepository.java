package com.stackroute.muzixservice.repository;

import com.stackroute.muzixservice.domain.Music;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends CrudRepository<Music,Integer> {
    @Query("select m from Music m where m.tname=:tname")
    public Music displayTrackByName(@Param("tname") String tname);
}
