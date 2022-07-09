package com.example.courtfinder.control;

import com.example.courtfinder.model.Court;

import org.osmdroid.views.MapView;

public interface IMapController {
    /**
     * Takes a court and draws a marker to the coordinations
     * @param court
     */
    void makeMarker(Court court);
}
