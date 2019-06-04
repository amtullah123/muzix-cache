package com.stackroute.muzixservice.listener;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component

public class CommandLineRunner implements ApplicationListener<ContextRefreshedEvent> {
    Music music=new Music();
    @Autowired
    MusicRepository musicRepository;
    @Autowired
    private Environment environment;
    @Override

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        music.setTid(Integer.parseInt(environment.getProperty("music1.tid")));
        music.setTname(environment.getProperty("music1.tname"));
        music.setComments(environment.getProperty("music1.comments"));
        musicRepository.save(music);

    }
}