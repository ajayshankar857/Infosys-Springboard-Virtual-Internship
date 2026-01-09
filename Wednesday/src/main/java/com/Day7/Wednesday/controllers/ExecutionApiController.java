package com.Day7.Wednesday.controllers;

import ch.qos.logback.classic.spi.Configurator;
import com.Day7.Wednesday.status.ExecutionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class ExecutionApiController {

    private String currentStatus = "IDLE";
    private int completedCount = 0;
    private final int totalCount = 10;

    @PostMapping("/schedule/run")
    public String triggerRun() {
        if (currentStatus.equals("RUNNING")) {
            return "Scan already in progress!";
        }

        currentStatus = "RUNNING";
        completedCount = 0;

        CompletableFuture.runAsync(() -> {
            try {
                for (int i = 1; i <= totalCount; i++) {
                    Thread.sleep(2000); // Simulate time taken for each test
                    completedCount = i;
                    System.out.println("Test " + i + " completed.");
                }
                currentStatus = "COMPLETED";
            } catch (InterruptedException e) {
                currentStatus = "ERROR";
            }
        });

        return "Test Suite started! Parallel execution is running in the background.";
    }

    // 2. CHECK STATUS (GET)
    @GetMapping("/execution/status")
    public ExecutionStatus getStatus() {
        return new ExecutionStatus(currentStatus, totalCount, completedCount);
    }
}
