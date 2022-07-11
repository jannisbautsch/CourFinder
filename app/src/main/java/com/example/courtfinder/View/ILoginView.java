package com.example.courtfinder.View;

public interface ILoginView {

    /**
     * Redirects on Valid
     * @param message
     */
    void OnLoginSuccess(String message);

    /**
     *  Redirects on Error
     * @param message
     */
    void OnLoginError(String message);
}