package com.example.courtfinder.model;

public interface ICourt {

    /**
     * returns ID of the Court
     *
     * @return String
     */
    String getId();

    /**
     * returns Name of the Court
     *
     * @return String
     */
    String getName();

    /**
     * returns Latitude of the Court
     *
     * @return Double
     */
    Double getLat();

    /**
     * returns Longitude of the Court
     *
     * @return Double
     */
    Double getLon();


}
