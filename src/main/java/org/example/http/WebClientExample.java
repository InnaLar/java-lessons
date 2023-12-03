package org.example.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

// TODO: json что это
// TODO: WebClient возможности
// TODO: генерация модели из json
// TODO: https://www.accuweather.com/ регистрация, реализация метода currentconditions https://developer.accuweather.com/accuweather-current-conditions-api/apis/get/currentconditions/v1/%7BlocationKey%7D
// TODO: ObjectMapper, после того как распарсишь json, можно сделать модель object обратно в json с помощью ObjectMapper

// 1. Получения списка городов с https://dataservice.accuweather.com/locations/v1/topcities/150?apikey=kRK8UAPHaOphrB82Ida62hMIdFnt36yB
// 2. Возможность выбора города из списка для получения погоды
// 3. Получение погоды с https://developer.accuweather.com/accuweather-current-conditions-api/apis/get/currentconditions/v1/%7BlocationKey%7D

public class WebClientExample {
    public static void main(final String[] args) throws IOException {
        WebClient webClient = WebClient.create("https://dataservice.accuweather.com/");
        TopcitiesRoot[] accuWeatherTopCities = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .pathSegment("locations", "v1", "topcities", "{count}")
                .queryParam("apikey", /*"kRK8UAPHaOphrB82Ida62hMIdFnt36yB"*/"dyKHmZXCEt9IF3mdJIjDuxZtpArMOLVv")
                .build(150))
            .retrieve()
            .bodyToMono(TopcitiesRoot[].class)
            .block();

        Object[] countries = Arrays.stream(accuWeatherTopCities)
            .map(c -> c.country.englishName)
            .distinct()
            .toArray();

        int cnt = 1;
        for (Object country: countries
             ) {
            System.out.printf("%d %s ", cnt, country);
            System.out.println();
            cnt++;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите номер страны.");

        String indexCountry = reader.readLine();

        int nCountry = Integer.parseInt(indexCountry);

        Object country = countries[nCountry - 1];

        Object[] cities = Arrays.stream(accuWeatherTopCities)
            .filter(c -> c.country.englishName.equals(countries[nCountry - 1]))
            .map(m -> City.builder().cityName(m.englishName).id(m.key).build())
            .toArray();

        cnt = 1;
        for (Object city: cities
        ) {

            System.out.printf("%d %s ", cnt, city);
            System.out.println();
            cnt++;
        }

        System.out.println("Введите номер города.");

        String indexCity = reader.readLine();
        int nCity = Integer.parseInt(indexCity);

        City city = (City) cities[nCity - 1];

        CurrentConditionsRoot[] accuWeatherCurrentConditions = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .pathSegment("currentconditions", "v1", "{locationKey}")
                .queryParam("apikey", "dyKHmZXCEt9IF3mdJIjDuxZtpArMOLVv")
                .build(city.getId()))
            .retrieve()
            .bodyToMono(CurrentConditionsRoot[].class)
            .block();

        Optional<CurrentConditionsRoot> currentConditionCity = Arrays.stream(accuWeatherCurrentConditions).findFirst();
        if (currentConditionCity.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("target/CurrentConditionsRoot.json"), currentConditionCity.get());
        }

        String cityCurrentConditions = Arrays.stream(accuWeatherCurrentConditions)
            .findFirst()
                .map(conditions -> CityCurrentWeather
                    .builder()
                    .city(city.getCityName())
                    .country((String) country)
                    .weatherText(conditions.weatherText)
                    .value(conditions.temperature.metric.value)
                    .unit(conditions.temperature.metric.unit)
                    .build())
                    .get()
                    .toString();

        System.out.println(cityCurrentConditions);
    }

}
