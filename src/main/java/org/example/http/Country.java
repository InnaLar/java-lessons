package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

class Country {
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("LocalizedName")
    public String localizedName;
}
