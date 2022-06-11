package com.example.courtfinder.model;

public class Court implements ICourt{

    private String id;
    private String name;
    private float lat;
    private float lon;


    public Court(String id, String name, float lat, float lon ){
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Float getLat() {
        return this.lat;
    }

    @Override
    public Float getLon() {
        return this.lon;
    }
}
