package org.example.http.mapper;

import org.example.http.model.api.currentconditions.CityCurrentWeather;
import org.example.http.model.api.currentconditions.CurrentConditionsRoot;
import org.example.http.model.api.locations.TopcitiesRoot;

public class CurrentWeatherMapper {
    public CityCurrentWeather toCityCurrentWeather(final CurrentConditionsRoot currentConditionsRoot, final TopcitiesRoot topcitiesRoot) {
        return CityCurrentWeather.builder()
            .city(topcitiesRoot.getEnglishName())
            .country(topcitiesRoot.getCountry().getEnglishName())
            .weatherText(currentConditionsRoot.getWeatherText())
            .value(currentConditionsRoot.getTemperature().getMetric().getValue())
            .unit(currentConditionsRoot.getTemperature().getMetric().getUnit())
            .build();
    }
}
