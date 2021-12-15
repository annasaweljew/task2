package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
    }

    @Test
    void should_compare_two_identical_strings() {
        String s1 = "konstantynopolitaneczka";
        String s2 = "konstantynopolitaneczka";
        assertTrue(task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_two_different_strings() {
        String s1 = "konstantynopolitaneczka";
        String s2 = "some other string";
        assertFalse(task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_two_empty_strings() {
        String s1 = "";
        String s2 = "";
        assertTrue(task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_two_strings_where_one_is_null() {
        String s1 = "konstantynopolitaneczka";
        String s2 = null;
        assertFalse(task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_empty_string_and_null_string() {
        String s1 = "";
        String s2 = null;
        assertTrue(task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_two_null_strings() {
        String s1 = null;
        String s2 = null;
        assertTrue(task.equalStrings(s1,s2));
    }

}