package org.example.http;

import org.example.http.client.AccuweatherClient;
import org.example.http.mapper.BarbecueConditionsMapper;
import org.example.http.mapper.CurrentWeatherMapper;
import org.example.http.service.AccuWeatherService;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

public class App {
    public static void main(final String[] args) throws IOException {
        WebClient webClient = WebClient.create("https://dataservice.accuweather.com/");
        AccuweatherClient accuweatherClient = new AccuweatherClient(webClient);
        CurrentWeatherMapper currentWeatherMapper = new CurrentWeatherMapper();
        BarbecueConditionsMapper barbecueConditionsMapper = new BarbecueConditionsMapper();
        AccuWeatherService accuWeatherService = new AccuWeatherService(accuweatherClient, currentWeatherMapper, barbecueConditionsMapper);
        accuWeatherService.checkWeather();
    }
}
