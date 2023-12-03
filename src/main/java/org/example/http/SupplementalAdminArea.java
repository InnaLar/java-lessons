package org.example.http;

import com.fasterxml.jackson.annotation.JsonProperty;

class SupplementalAdminArea {
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("Level")
    public int level;
    @JsonProperty("LocalizedName")
    public String localizedName;
}
