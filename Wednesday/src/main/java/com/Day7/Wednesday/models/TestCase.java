package com.Day7.Wednesday.models;

public class TestCase {

    private final String testName;
    private final String status;
    private final long duration;
    private final String errorMessage;

    public TestCase(String testName, String status, long duration, String errorMessage) {
        this.testName = testName;
        this.status = status;
        this.duration = duration;
        this.errorMessage = errorMessage;
    }

    public String getTestName() {
        return testName;
    }

    public String getStatus() {
        return status;
    }

    public long getDuration() {
        return duration;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}