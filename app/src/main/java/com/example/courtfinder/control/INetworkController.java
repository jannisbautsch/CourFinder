package com.example.courtfinder.control;

import android.os.AsyncTask;

import com.example.courtfinder.model.Court;

import org.json.JSONObject;

public interface INetworkController {

    void makeRequest(IVolleyJSONArrayCallback callback, String url);

    void postRequest(IVolleyJSONCallback callback, String url, Double lat, Double lon);
}
