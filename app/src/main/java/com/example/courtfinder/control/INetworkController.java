package com.example.courtfinder.control;

public interface INetworkController {

    /**
     * makes API call with GET
     **/
    void getRequest(IVolleyJSONArrayCallback callback, String url);

    /**
     * makes API call with POST
     **/
    void postRequest(IVolleyJSONCallback callback, String url, Double lat, Double lon);
}
