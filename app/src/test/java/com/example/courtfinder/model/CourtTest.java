package com.example.courtfinder.model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CourtTest {

    @Test
    public void getsCorrectId(){
        Court court = new Court("1234", "Cool Court", 53.123, 13.123);
        String id = court.getId();
        assertEquals(id, "1234");
    };

    @Test
    public void getsCorrectName(){
        Court court = new Court("1234", "Cool Court", 53.123, 13.123);
        String name = court.getName();
        assertEquals(name, "Cool Court");
    };

    @Test
    public void getsCorrectLat(){
        Court court = new Court("1234", "Cool Court", 53.123, 13.123);
        double lat = court.getLat();
        assertEquals(lat, 53.123, 0);
    };


    @Test
    public void getsCorrectLon(){
        Court court = new Court("1234", "Cool Court", 53.123, 13.123);
        double lon = court.getLon();
        assertEquals(lon, 13.123, 0);
    };


}