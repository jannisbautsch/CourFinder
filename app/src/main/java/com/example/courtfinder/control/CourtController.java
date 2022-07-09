package com.example.courtfinder.control;

import android.content.Context;

import com.example.courtfinder.model.Court;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class CourtController implements ICourtController {


    @Override
    public void getAllCourts(Context ctx, MapView map) {
        NetworkController.getInstance(ctx).getRequest(new IVolleyJSONArrayCallback() {
                                                          @Override
                                                          public void onSuccess() {

                                                          }
                                                          @Override
                                                          public void onSuccess(JSONArray result) {
                                                              for (int i = 0; i < result.length(); i++) {
                                                                  try {
                                                                      JSONObject resCourt = result.getJSONObject(i);
                                                                      String name = resCourt.getString("name");
                                                                      String id = resCourt.getString("id");
                                                                      Double lat = resCourt.getDouble("lat");
                                                                      Double lon = resCourt.getDouble("lon");

                                                                      Court court = new Court(id, name, lat, lon);
                                                                      MapController.getInstance(map).makeMarker(court);

                                                                  } catch (JSONException e) {
                                                                      e.printStackTrace();
                                                                  }
                                                              }
                                                          }
                                                      },
                "https://courtfinder-api.herokuapp.com/api/allCourts");
    }


    @Override
    public void newCourt(Context ctx, GeoPoint point, MapView map) {

        NetworkController.getInstance(ctx).postRequest(new IVolleyJSONCallback() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onSuccess(JSONObject response) {
                Court court = new Court(response.toString(), "coolName", point.getLatitude(), point.getLongitude());
                MapController.getInstance(map).makeMarker(court);

            }
        }, "https://courtfinder-api.herokuapp.com/api/newCourt", point.getLatitude(), point.getLongitude());

    }

}
