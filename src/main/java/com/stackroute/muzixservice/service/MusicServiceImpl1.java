package com.stackroute.muzixservice.service;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;

import java.util.List;

public class MusicServiceImpl1 implements MusicService {

    @Override
    public Music saveTrack(Music music) {
        return null;
    }

    @Override
    public List<Music> getAllTracks() {
        return null;
    }

    @Override
    public Music displayTrackById(int tid) {
        return null;
    }

    @Override
    public void deleteTrack(int trackId) {

    }

    @Override
    public Music updateTrackComments(Music music, int tid) throws TrackNotFoundException {
        return null;
    }
}
