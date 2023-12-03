package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

class GeoPosition {
    @JsonProperty("Elevation")
    public Elevation elevation;
    @JsonProperty("Latitude")
    public double latitude;
    @JsonProperty("Longitude")
    public double longitude;
}
