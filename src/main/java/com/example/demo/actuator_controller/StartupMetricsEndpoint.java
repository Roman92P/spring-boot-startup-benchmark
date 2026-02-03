package com.example.demo.actuator_controller;

import com.example.demo.model.StartUpPerformance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Roman Pashkov created on 03.02.2026 inside the package - com.example.demo.actuator_controller
 */
@Component
@Endpoint(id = "startup-metrics")
public class StartupMetricsEndpoint {

    @Autowired
    StartUpPerformance startUpPerformance;

    @ReadOperation
    public ResponseEntity<String> testEndpoint() {
        if (performanceMetricsNotReady())
            return ResponseEntity.ok("Not ready");
        else
            return ResponseEntity.ok(startUpPerformance.toString());
    }

    private boolean performanceMetricsNotReady() {
        return startUpPerformance.getApplicationStartUpTime().isEmpty()
                || startUpPerformance.getDataReadTime().isEmpty()
                || startUpPerformance.getDataParsingTime().isEmpty();
    }

}
