package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

class Metric {
    @JsonProperty("Value")
    public double value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
}
