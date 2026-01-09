package com.Day7.Wednesday.status;
public class ExecutionStatus {

    private String status;
    private int totalTests;
    private int completedTests;

    public ExecutionStatus(String status, int totalTests, int completedTests) {
        this.status = status;
        this.totalTests = totalTests;
        this.completedTests = completedTests;
    }
    public String getStatus() {
        return status;
    }

    public int getTotalTests() {
        return totalTests;
    }

    public int getCompletedTests() {
        return completedTests;
    }
}