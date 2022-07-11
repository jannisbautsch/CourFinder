package com.example.courtfinder.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class UserTest {

    @Test
    public void emailIsEmpty() {
        User user =  new User("", "courtfinder123");
        int loginCode = user.isValid();
        assertEquals(loginCode, (0));
    }

    @Test
    public void notValidEmailAdress() {
        User user =  new User("admin", "courtfinder123");
        int loginCode = user.isValid();
        assertEquals(loginCode, (1));
    }


    @Test
    public void passwordIsEmpty() {
        User user =  new User("hello@courtfinder.com", "");
        int loginCode = user.isValid();
        assertEquals(loginCode, (2));
    }


    @Test
    public void passwordToShort() {
        User user =  new User("hello@courtfinder.com", "court");
        int loginCode = user.isValid();
        assertEquals(loginCode, (3));
    }

    @Test
    public void correctEmail() {
        User user =  new User("hello@courtfinder.com", "courtfinder123");
        int loginCode = user.isValid();
        assertEquals(loginCode, (-1));
    }
}