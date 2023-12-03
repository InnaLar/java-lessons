package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

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
