package com.stackroute.Muzixapp;

import com.stackroute.Muzixapp.domain.Track;
import com.stackroute.Muzixapp.repository.TrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;



@Component
public class ApplicationStart implements ApplicationListener<ApplicationReadyEvent> , CommandLineRunner
{
    private static final Logger logger = LoggerFactory.getLogger(ApplicationStart.class);

    @Autowired
    private TrackRepository trackRepository;


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        trackRepository.save(new Track(1, "Shape of you", "Good"));
        System.out.println("Application Listener");

    }

    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track(2, "Na Na Na", "good"));
        trackRepository.findAll().forEach((track) -> {
            logger.info("{}", track);
        });
        System.out.println("Command line runner");

    }
}