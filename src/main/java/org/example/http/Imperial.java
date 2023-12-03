package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

class Imperial {
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
    @JsonProperty("Value")
    public double value;
}
