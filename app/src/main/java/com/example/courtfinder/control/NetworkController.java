package com.example.courtfinder.control;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

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

    public void makeRequest(final IVolleyCallback callback, String url) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                callback.onSuccess(response);
            }
        }, error -> Toast.makeText(ctx, "error", Toast.LENGTH_LONG).show());

        QueueManager.getInstance(ctx).addToRequestQueue(request);

    }


    @Override
    public void makeRequest() {

    }
}
