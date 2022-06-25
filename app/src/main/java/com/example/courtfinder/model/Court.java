package com.example.courtfinder.model;

public class Court implements ICourt {

    private String id;
    private String name;
    private Double lat;
    private Double lon;


    public Court(String name, double lat, double lon ){
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
    public Double getLat() {
        return this.lat;
    }

    @Override
    public Double getLon() {
        return this.lon;
    }
}
