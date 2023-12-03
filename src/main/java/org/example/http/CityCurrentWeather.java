package org.example.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter

public class CityCurrentWeather {
    private String country;
    private String city;
    private String weatherText;
    private double value;
    private String unit;

    public String toString() {
        return String.format("In %s, %s %s %f, %s", city, country, weatherText, value, unit);
    }
}
