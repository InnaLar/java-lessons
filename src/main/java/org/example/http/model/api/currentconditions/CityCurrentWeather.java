package org.example.http.model.api.currentconditions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CityCurrentWeather {
    private String country;
    private String city;
    private String weatherText;
    private double value;
    private String unit;

    @Override
    public String toString() {
        return String.format("In %s, %s %s %f, %s", city, country, weatherText, value, unit);
    }
}
