package com.example.courtfinder.control;

import com.example.courtfinder.model.Court;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MapController {

    private static MapController instance;
    private static MapView map;

    private MapController(MapView map) {
        this.map = map;
    }

    public static synchronized MapController getInstance(MapView map) {
        if (instance == null) {
            instance = new MapController(map);
        }
        return instance;
    }

    public void makeMarker(Court court) {
        GeoPoint courtPoint = new GeoPoint(court.getLat(), court.getLon());
        Marker courtMarker = new Marker(map);
        courtMarker.setPosition(courtPoint);
        courtMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER);
        courtMarker.setTitle(court.getName());
        map.getOverlays().add(courtMarker);
    }

}
