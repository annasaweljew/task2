package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void should_compare_two_identical_strings() {
        String s1 = "konstantynopolitaneczka";
        String s2 = "konstantynopolitaneczka";
        assertTrue(Task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_two_different_strings() {
        String s1 = "konstantynopolitaneczka";
        String s2 = "some other string";
        assertFalse(Task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_two_empty_strings() {
        String s1 = "";
        String s2 = "";
        assertTrue(Task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_two_strings_where_one_is_null() {
        String s1 = "konstantynopolitaneczka";
        String s2 = null;
        assertFalse(Task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_empty_string_and_null_string() {
        String s1 = "";
        String s2 = null;
        assertTrue(Task.equalStrings(s1,s2));
    }

    @Test
    void should_compare_two_null_strings() {
        String s1 = null;
        String s2 = null;
        assertTrue(Task.equalStrings(s1,s2));
    }

}