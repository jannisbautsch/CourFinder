package com.example.courtfinder.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class UserTest {

    @Test
    public void emailValidator_CorrectEmailSimple() {
        User user =  new User("admin@counterfinder.de", "courtfinder123");
        int loginCode = user.isValid();
        assertEquals(loginCode, (-1));
    }
}