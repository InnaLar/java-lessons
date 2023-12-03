package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

class TimeZone {
    @JsonProperty("Code")
    public String code;
    @JsonProperty("GmtOffset")
    public double gmtOffset;
    @JsonProperty("IsDaylightSaving")
    public boolean isDaylightSaving;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("NextOffsetChange")
    public Date nextOffsetChange;
}
