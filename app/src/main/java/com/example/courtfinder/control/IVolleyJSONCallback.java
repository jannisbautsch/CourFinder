package com.example.courtfinder.control;

import org.json.JSONObject;

public interface IVolleyJSONCallback extends IVolleyCallback{

    @Override
    void onSuccess();

    void onSuccess(JSONObject result);

}
