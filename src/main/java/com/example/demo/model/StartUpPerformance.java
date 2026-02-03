package com.example.demo.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Roman Pashkov created on 03.02.2026 inside the package - com.example.demo.model
 */
@Component
@Data
public class StartUpPerformance {

    private String applicationStartUpTime;

    private String dataReadTime;

    private String dataParsingTime;
}
