package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

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















