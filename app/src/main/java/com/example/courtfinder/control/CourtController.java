package com.example.courtfinder.control;

import android.content.Context;
import android.widget.Toast;

import com.example.courtfinder.MainActivity;
import com.example.courtfinder.model.Court;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.views.MapView;

import java.util.Map;

public class CourtController implements ICourtController{

    private Court court;

    @Override
    public Court newCourt(String name, double lat, double lon ) {
        this.court = new Court(name, lat, lon);
        return this.court;
    }

    @Override
    public void getAllCourts(Context ctx, MapView map) {
        NetworkController.getInstance(ctx).makeRequest(new IVolleyCallback() {
                                                                         @Override
                                                                         public void onSuccess(JSONArray result) {
                                                                             Toast.makeText(ctx, result.toString(), Toast.LENGTH_LONG).show();
                                                                             for (int i = 0; i < result.length(); i++) {
                                                                                 String name = "name";
                                                                                 try {
                                                                                     JSONObject resCourt = result.getJSONObject(i);
                                                                                     Double lat = resCourt.getDouble("lat");
                                                                                     Double lon = resCourt.getDouble("lon");

                                                                                     Court court = newCourt(name, lat, lon);

                                                                                     MapController.getInstance().makeMarker(map, court);

                                                                                 } catch (JSONException e) {
                                                                                     e.printStackTrace();
                                                                                 }
                                                                             }
                                                                         }
                                                                     },
                "https://courtfinder-api.herokuapp.com/api/allCourts");
    }


    @Override
    public void saveCourt() {
        //api call
        //return bool?
    }
}
