package com.example.courtfinder.control;

import org.json.JSONObject;

public interface IVolleyJSONCallback extends IVolleyCallback {

    void onSuccess(JSONObject result);
}
