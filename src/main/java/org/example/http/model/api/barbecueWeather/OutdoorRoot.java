package org.example.http.model.api.barbecueWeather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OutdoorRoot {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ID")
    private int iD;
    @JsonProperty("Value")
    private int value;
    @JsonProperty("Category")
    private String category;
}


