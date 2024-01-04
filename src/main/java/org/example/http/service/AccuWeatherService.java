package org.example.http.service;

import lombok.RequiredArgsConstructor;
import org.example.http.client.AccuweatherClient;
import org.example.http.mapper.BarbecueConditionsMapper;
import org.example.http.mapper.CurrentWeatherMapper;
import org.example.http.model.api.barbecueweather.OutdoorRoot;
import org.example.http.model.api.currentconditions.CurrentConditionsRoot;
import org.example.http.model.api.locations.TopcitiesRoot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

// TODO: json что это
// TODO: WebClient возможности
// TODO: генерация модели из json
// TODO: https://www.accuweather.com/ регистрация, реализация метода currentconditions https://developer.accuweather.com/accuweather-current-conditions-api/apis/get/currentconditions/v1/%7BlocationKey%7D
// TODO: ObjectMapper, после того как распарсишь json, можно сделать модель object обратно в json с помощью ObjectMapper

// 1. Получения списка городов с https://dataservice.accuweather.com/locations/v1/topcities/150?apikey=kRK8UAPHaOphrB82Ida62hMIdFnt36yB
// 2. Возможность выбора города из списка для получения погоды
// 3. Получение погоды с https://developer.accuweather.com/accuweather-current-conditions-api/apis/get/currentconditions/v1/%7BlocationKey%7D

@RequiredArgsConstructor
@SuppressWarnings("PMD.SystemPrintln")
public class AccuWeatherService {
    private final AccuweatherClient accuweatherClient;
    private final CurrentWeatherMapper currentWeatherMapper;
    private final BarbecueConditionsMapper barbecueConditionsMapper;

    public void checkWeather() {
        TopcitiesRoot[] accuWeatherTopCities = accuweatherClient.getTopcitiesRoot();

        for (TopcitiesRoot topcity : accuWeatherTopCities) {
            System.out.println(topcity.getKey() + ", id " + topcity.getEnglishName());
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            System.out.println("Введите номер города.");

            String indexCity = reader.readLine();
            if (indexCity == null) {
                throw new IllegalStateException("Неверный ввод");
            }
            int nCity = Integer.parseInt(indexCity);

            TopcitiesRoot topcitiesRoot = Arrays.stream(accuWeatherTopCities)
                .filter(city -> city.getKey().equals(String.valueOf(nCity)))
                .findFirst()
                .orElseThrow();

            CurrentConditionsRoot[] accuWeatherCurrentConditions =
                accuweatherClient.getCurrentConditionsRoot(topcitiesRoot.getKey());

            CurrentConditionsRoot currentConditionCity = Arrays.stream(accuWeatherCurrentConditions)
                .findFirst()
                .orElseThrow();

            currentWeatherMapper.toCityCurrentWeather(currentConditionCity, topcitiesRoot);

            System.out.println(currentWeatherMapper.toCityCurrentWeather(currentConditionCity, topcitiesRoot));

            OutdoorRoot[] barbecueConditions =
                accuweatherClient.getOutdoorRoot(topcitiesRoot.getKey());

            Arrays.stream(barbecueConditions)
                .map(barbecueConditionsMapper::toOutdoorConditions)
                .forEach(System.out::println);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}
