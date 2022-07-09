package com.example.courtfinder.control;

import org.json.JSONArray;

public interface IVolleyJSONArrayCallback extends IVolleyCallback {
    void onSuccess(JSONArray result);
}
