package com.example.courtfinder.control;

import android.content.Context;

import com.example.courtfinder.model.Court;

import org.osmdroid.views.MapView;

import java.util.Map;

public interface ICourtController {

    Court newCourt(String name, double lat, double lon);

    void getAllCourts(Context ctx, MapView map);

    void saveCourt(Court court);

}
