package com.example.courtfinder.control;

import android.content.Context;
import android.widget.Toast;

import com.example.courtfinder.MainActivity;
import com.example.courtfinder.model.Court;

import org.json.JSONObject;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MapController {

    private static MapController instance;

    private MapController() {

    }

    public static synchronized MapController getInstance() {
        if (instance == null) {
            instance = new MapController();
        }
        return instance;
    }

    public void makeMarker(MapView map, Court court) {
        GeoPoint courtPoint = new GeoPoint(court.getLat(), court.getLon());

        Marker courtMarker = new Marker(map);
        courtMarker.setPosition(courtPoint);
        courtMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);
        courtMarker.setTitle(court.getName());
        map.getOverlays().add(courtMarker);
    }

    public void newCourt(Context ctx, MapView map, GeoPoint point) {
        NetworkController.getInstance(ctx).postRequest(new IVolleyJSONCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onSuccess(JSONObject response) {
                Court court = new Court(response.toString(), point.getLatitude(), point.getLongitude());
                makeMarker(map, court);
                Toast.makeText(ctx, response.toString(), Toast.LENGTH_LONG).show();


            }
        }, "https://courtfinder-api.herokuapp.com/api/newCourt", point.getLatitude(), point.getLongitude());

    }

}
