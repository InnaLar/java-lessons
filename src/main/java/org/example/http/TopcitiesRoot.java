package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class TopcitiesRoot {
    @JsonProperty("AdministrativeArea")
    public AdministrativeArea administrativeArea;
    @JsonProperty("Country")
    public Country country;
    @JsonProperty("DataSets")
    public ArrayList<String> dataSets;
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("GeoPosition")
    public GeoPosition geoPosition;
    @JsonProperty("IsAlias")
    public boolean isAlias;
    @JsonProperty("Key")
    public String key;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("PrimaryPostalCode")
    public String primaryPostalCode;
    @JsonProperty("Rank")
    public int rank;
    @JsonProperty("Region")
    public Region region;
    @JsonProperty("SupplementalAdminAreas")
    public ArrayList<SupplementalAdminArea> supplementalAdminAreas;
    @JsonProperty("TimeZone")
    public TimeZone timeZone;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Version")
    public int version;
}

class SupplementalAdminArea {
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("Level")
    public int level;
    @JsonProperty("LocalizedName")
    public String localizedName;
}

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

class AdministrativeArea {
    @JsonProperty("CountryID")
    public String countryID;
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("EnglishType")
    public String englishType;
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("Level")
    public int level;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("LocalizedType")
    public String localizedType;
}

class Country {
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("LocalizedName")
    public String localizedName;
}

class Elevation {
    @JsonProperty("Imperial")
    public Imperial imperial;
    @JsonProperty("Metric")
    public Metric metric;
}

class GeoPosition {
    @JsonProperty("Elevation")
    public Elevation elevation;
    @JsonProperty("Latitude")
    public double latitude;
    @JsonProperty("Longitude")
    public double longitude;
}

class Imperial {
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
    @JsonProperty("Value")
    public double value;
}

class Metric {
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
    @JsonProperty("Value")
    public double value;
}

class Region {
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("LocalizedName")
    public String localizedName;
}
