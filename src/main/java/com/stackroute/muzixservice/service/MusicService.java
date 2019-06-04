package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;


import java.util.List;

public interface MusicService {

        public Music saveTrack(Music music);

        public List<Music> getAllTracks();

   public Music displayTrackById(int tid);

   // public Music displayTrackByName(String tname);
//    public List<Music> updateTrack();

        public void deleteTrack(int trackId);

    public Music updateTrackComments(Music music, int tid) throws TrackNotFoundException;




//    public List<TrackDetails> displayTrack();
//
//    public TrackDetails displayTrackById(int trackId);

}






