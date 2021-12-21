package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TaskTest {

    private final TestLogger logger = new TestLogger();

    @Test
    void should_compare_two_identical_strings() {
        String s1 = "konstantynopolitaneczka";
        String s2 = "konstantynopolitaneczka";
        var result = Task.equalStrings(s1, s2);
        logger.logSingleTestResult("should_compare_two_identical_strings", result==true);
        assertTrue(result);
    }

    @Test
    void should_compare_two_different_strings() {
        String s1 = "konstantynopolitaneczka";
        String s2 = "some other string";
        var result = Task.equalStrings(s1,s2);
        logger.logSingleTestResult("should_compare_two_different_strings", result==false);
        assertFalse(result);
    }

    @Test
    void should_compare_two_empty_strings() {
        String s1 = "";
        String s2 = "";
        var result = Task.equalStrings(s1,s2);
        logger.logSingleTestResult("should_compare_two_empty_strings", result==true);
        assertTrue(result);
    }

    @Test
    void should_compare_two_strings_where_one_is_null() {
        String s1 = "konstantynopolitaneczka";
        String s2 = null;
        var result = Task.equalStrings(s1,s2);
        logger.logSingleTestResult("should_compare_two_strings_where_one_is_null", result==false);
        assertFalse(result);
    }

    @Test
    void should_compare_empty_string_and_null_string() {
        String s1 = "";
        String s2 = null;
        var result = Task.equalStrings(s1,s2);
        logger.logSingleTestResult("should_compare_empty_string_and_null_string", result==true);
        assertTrue(result);
    }

    @Test
    void should_compare_two_null_strings() {
        String s1 = null;
        String s2 = null;
        var result = Task.equalStrings(s1,s2);
        logger.logSingleTestResult("should_compare_two_null_strings", result==true);
        assertTrue(Task.equalStrings(s1,s2));
    }

    @AfterAll
    void logTestResults() {
        logger.saveResults();
    }
}