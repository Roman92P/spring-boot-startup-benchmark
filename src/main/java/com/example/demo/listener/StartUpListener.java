package com.example.demo.listener;

import com.example.demo.model.StartUpPerformance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Roman Pashkov created on 03.02.2026 inside the package - com.example.demo.aspect
 */

@Slf4j
@Component
public class StartUpListener implements ApplicationListener<ApplicationStartedEvent> {

    @Autowired
    StartUpPerformance startUpPerformance;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        startUpPerformance.setApplicationStartUpTime(String.valueOf(event.getTimeTaken()));
    }
}
