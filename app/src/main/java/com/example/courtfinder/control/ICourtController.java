package com.example.courtfinder.control;

import android.content.Context;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public interface ICourtController {

    /**
     * calls Network controller and gets Arraylist of all Courts
     *
     * @param ctx activity context
     * @param map map
     **/
    void getAllCourts(Context ctx, MapView map);

    /**
     * calls Network controller to save new Court in remote DB
     *
     * @param ctx activity context
     * @param map map
     * @param point geopoint where the Court should be
     **/
    void newCourt(Context ctx, GeoPoint point, MapView map);

}
