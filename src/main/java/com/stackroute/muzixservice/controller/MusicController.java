package com.stackroute.muzixservice.controller;

import com.stackroute.muzixservice.service.MusicService;
import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixservice.exceptions.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class MusicController {
    MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }


    @PostMapping("/music")
    public ResponseEntity<?> saveTrack(@RequestBody Music music)  throws TrackAlreadyExistsException {
        RequestEntity requestEntity;
       // try {
            musicService.saveTrack(music);
            return new ResponseEntity<String>("succefully created",HttpStatus.OK);
//        } catch (TrackAlreadyExistsException ex) {
//            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//        }
    }

    @GetMapping("/music")
    public ResponseEntity<?> getAllTracks() {
        return new ResponseEntity<List<Music>>(musicService.getAllTracks(), HttpStatus.OK);
    }


//    @GetMapping("/music")
//    public ResponseEntity<?> getAllTracks()
//    {
//        List<Music> musicList=musicService.getAllTracks();
//        return new ResponseEntity<List<Music>>(musicList,HttpStatus.OK);
//    }
    //    @GetMapping("/music/{tid}")
//    public ResponseEntity<?> displayTracksById(@PathVariable int tid)
//    {
//        Music musicList=musicService.displayTracksById(tid);
//        return new ResponseEntity<Music>(musicList,HttpStatus.OK);
//    }


//    @GetMapping("/music/{tname}")
//    public ResponseEntity<?> displayTrackByName(@PathVariable String tname)
//    {
//        Music musicList=musicService.displayTrackByName(tname);
//        return new ResponseEntity<Music>(musicList,HttpStatus.OK);
//    }


@GetMapping("/music/{tid}")
    public ResponseEntity<?> displayTrackById(@PathVariable int tid)
    {
        Music musicList=musicService.displayTrackById(tid);
        return new ResponseEntity<Music>(musicList,HttpStatus.OK);
    }
    @DeleteMapping("/music/{tid}")
    public ResponseEntity<?> deleteTrack(@PathVariable int tid)
    {
        musicService.deleteTrack(tid);
        return new ResponseEntity<List<Music>>(musicService.getAllTracks(),HttpStatus.OK);
    }
    @PutMapping("/music/{tid}")
    public ResponseEntity<?> updateTrack(@RequestBody Music music, @PathVariable int tid) throws TrackNotFoundException {
        //  try{
        Music musicList=musicService.updateTrackComments(music,tid);
        return new ResponseEntity<Music>(musicList, HttpStatus.OK);}
//        catch (TrackNotFoundException ex)
//        {
//            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//        }
}
