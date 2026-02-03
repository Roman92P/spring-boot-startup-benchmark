package com.example.demo.scheduler;

import com.example.demo.model.StartUpPerformance;
import com.example.demo.repository.TestDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Roman Pashkov created on 03.02.2026 inside the package - com.example.demo.scheduler
 */

@Component
@Slf4j
public class RetrieveDataTask {

    @Autowired
    TestDataRepository testDataRepository;

    @Autowired
    StartUpPerformance startUpPerformance;


    @Scheduled(initialDelay = 2000, fixedDelay = Long.MAX_VALUE)
    public void retrieveDataFromDb() throws InterruptedException {
        long startDataRetrieve = System.nanoTime();

        testDataRepository.getReferenceById(1L);

        long retrieveDurationMs = TimeUnit.NANOSECONDS.toMillis(
                System.nanoTime() - startDataRetrieve
        );

        startUpPerformance.setDataReadTime(String.valueOf(retrieveDurationMs) + "ms");

        long startParsing = System.nanoTime();

        Thread.sleep(2000);

        long parsingDurationMs = TimeUnit.NANOSECONDS.toMillis(
                System.nanoTime() - startParsing
        );

        startUpPerformance.setDataParsingTime(String.valueOf(parsingDurationMs) + "ms");

    }
}
