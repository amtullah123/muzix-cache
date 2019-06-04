package com.stackroute.muzixservice.listener;

import com.stackroute.muzixservice.domain.Music;
import com.stackroute.muzixservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
public class ApplicationListener implements CommandLineRunner {
    @Value("${music2.tid}")
    private int tid;
    @Value("${music2.tname}")
    private String tname;
    @Value("${music2.comments}")
    private String comments;

    Music music=new Music();
    @Autowired
    MusicRepository musicRepository;
    @Override
    public void run(String... args) throws Exception {
        music.setTid(tid);
        music.setTname(tname);
        music.setComments(comments);
        musicRepository.save(music);
    }
}