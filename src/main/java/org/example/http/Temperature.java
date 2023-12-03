package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

class Temperature {
    @JsonProperty("Metric")
    public Metric metric;
    @JsonProperty("Imperial")
    public Imperial imperial;
}
