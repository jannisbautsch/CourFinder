package com.example.courtfinder.control;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class QueueManager {

    //@TODO put into java package!

    private static QueueManager instance;
    private static Context ctx;
    private RequestQueue requestQueue;


    private QueueManager(Context ctx) {
        this.ctx = ctx;
        requestQueue = getRequestQueue();
    }


    public static synchronized QueueManager getInstance(Context ctx) {
        if (instance == null) {
            instance = new QueueManager(ctx);
        }
        return instance;
    }


    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
