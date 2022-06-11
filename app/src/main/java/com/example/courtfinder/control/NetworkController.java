package com.example.courtfinder.control;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.courtfinder.MainActivity;

public class NetworkController implements INetworkController {

    private RequestQueue queue;
    private StringRequest stringRequest;
    private String url;
    private Context ctx;

    public NetworkController(Context ctx){
        this.ctx = ctx;
    };

    public void makeRequest(){
        this.url = "https://courtfinder-api.herokuapp.com/api/allCourts";
        this.queue = Volley.newRequestQueue(ctx);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
            }}, new Response.ErrorListener(){
            public void onErrorResponse(VolleyError error){Toast.makeText(ctx, "error", Toast.LENGTH_LONG).show(); }

        });

        queue.add(stringRequest);
    }




}
