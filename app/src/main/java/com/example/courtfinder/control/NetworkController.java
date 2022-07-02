package com.example.courtfinder.control;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.courtfinder.model.Court;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NetworkController implements INetworkController {

    private static NetworkController instance;
    private final Context ctx;

    private NetworkController(Context ctx) {
        this.ctx = ctx;
    }

    public static synchronized NetworkController getInstance(Context ctx) {
        if (instance == null) {
            instance = new NetworkController(ctx);
        }
        return instance;
    }

    public void makeRequest(final IVolleyJSONArrayCallback callback, String url) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                callback.onSuccess(response);
            }
        }, error -> Toast.makeText(ctx, "error", Toast.LENGTH_LONG).show());

        QueueManager.getInstance(ctx).addToRequestQueue(request);

    }


    @Override
    public void postRequest(String url, Court court) {

        JSONObject object = new JSONObject();
        try {
            //input your API parameters
            object.put("lat",court.getLat());
            object.put("lon",court.getLon());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                callback.onSuccessString(response);
                Toast.makeText(ctx, response.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO: Handle error
                Toast.makeText(ctx, "error", Toast.LENGTH_LONG).show();
            }
        });

        QueueManager.getInstance(ctx).addToRequestQueue(request);

    }

}
