package com.example.courtfinder.model;


public interface IUser {

    /**
     * returns Value of the Email
     *
     * @return String
     */
    String getEmail();

    /**
     * returns Value of the Password
     *
     * @return String
     */
    String getPassword();

    /**
     * returns Int Code for Validation
     *
     * @return Int
     */
    int isValid();
}
