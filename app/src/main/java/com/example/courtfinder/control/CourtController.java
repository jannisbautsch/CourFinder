package com.example.courtfinder.control;

import com.example.courtfinder.model.Court;

public class CourtController implements ICourtController{

    private Court court;

    @Override
    public Court newCourt(String name, float lat, float lon ) {
        this.court = new Court(name, lat, lon);
        return this.court;
    }

    @Override
    public Court[] getAllCourts() {
        //api call
        return new Court[0];
    }

    @Override
    public void saveCourt() {
        //api call
        //return bool?
    }
}
