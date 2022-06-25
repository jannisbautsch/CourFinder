package com.example.courtfinder.control;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class NetworkController implements INetworkController {


    private static NetworkController instance;
    private final Context ctx;
    private RequestQueue requestQueue;

    private NetworkController(Context ctx) {
        this.ctx = ctx;
    }

    public static synchronized NetworkController getInstance(Context ctx) {
        if (instance == null) {
            instance = new NetworkController(ctx);
        }
        return instance;
    }

    public void makeRequest() {
        String url = "https://courtfinder-api.herokuapp.com/api/allCourts";
        RequestQueue queue = Volley.newRequestQueue(ctx);

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(ctx, response.toString(), Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ctx, "error", Toast.LENGTH_LONG).show();
            }

        });

//        QueueManager.getInstance(ctx).
        QueueManager.getInstance(ctx).addToRequestQueue(request);

//        queue.add(request);
    }


}
