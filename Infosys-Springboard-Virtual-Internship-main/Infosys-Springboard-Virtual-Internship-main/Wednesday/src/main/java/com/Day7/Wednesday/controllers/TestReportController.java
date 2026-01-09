package com.Day7.Wednesday.controllers;

import com.Day7.Wednesday.models.TestCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestReportController {

    @GetMapping("/test-report")
    public String getTestResults(Model model) {

        List<TestCase> results = Arrays.asList(
                new TestCase("User Login Flow", "Pass", 120, null),
                new TestCase("Purchase API Endpoint", "Fail", 450, "500 Internal Server Error"),
                new TestCase("Password Reset UI", "Skipped", 0, "Dependency not met"),
                new TestCase("Search Functionality", "Pass", 85, null)
        );

        long passedCount = results.stream()
                .filter(t -> t.getStatus().equals("Pass"))
                .count();

        model.addAttribute("testResults", results);
        model.addAttribute("passed", passedCount);
        model.addAttribute("total", results.size());

        return "test-report-view";
    }
}