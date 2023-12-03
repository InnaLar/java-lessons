package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

class Elevation {
    @JsonProperty("Imperial")
    public Imperial imperial;
    @JsonProperty("Metric")
    public Metric metric;
}
