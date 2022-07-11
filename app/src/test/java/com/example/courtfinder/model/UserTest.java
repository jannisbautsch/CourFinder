package com.example.courtfinder.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class UserTest {
    
    @Test
    public void emailValidator_EmailIsEmpty() {
        User user =  new User("", "courtfinder123");
        int loginCode = user.isValid();
        assertEquals(loginCode, (0));
    }

    @Test
    public void emailValidator_NotValidEmailAdress() {
        User user =  new User("admin", "courtfinder123");
        int loginCode = user.isValid();
        assertEquals(loginCode, (1));
    }


    @Test
    public void emailValidator_PasswordIsEmpty() {
        User user =  new User("hello@courtfinder.com", "");
        int loginCode = user.isValid();
        assertEquals(loginCode, (2));
    }


    @Test
    public void emailValidator_PasswordToShort() {
        User user =  new User("hello@courtfinder.com", "court");
        int loginCode = user.isValid();
        assertEquals(loginCode, (3));
    }

    @Test
    public void emailValidator_CorrectEmail() {
        User user =  new User("hello@courtfinder.com", "courtfinder123");
        int loginCode = user.isValid();
        assertEquals(loginCode, (-1));
    }
}