package com.lstech.report;

public record ReportEntry(
        String step,
        String operation,
        String request,
        int statusCode,
        String response,
        boolean success) {
}