package com.example.courtfinder.control;

import com.example.courtfinder.model.Court;

public interface ICourtController {

    Court newCourt(String name, float lat, float lon );

    Court[] getAllCourts();

    void saveCourt();

}
