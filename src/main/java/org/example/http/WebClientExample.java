package org.example.http;

import org.springframework.web.reactive.function.client.WebClient;

// TODO: json что это
// TODO: WebClient возможности
// TODO: генерация модели из json
// TODO: https://www.accuweather.com/ регистрация, реализация метода currentconditions https://developer.accuweather.com/accuweather-current-conditions-api/apis/get/currentconditions/v1/%7BlocationKey%7D
// TODO: ObjectMapper, после того как распарсишь json, можно сделать модель object обратно в json с помощью ObjectMapper



// 1. Получения списка городов с https://dataservice.accuweather.com/locations/v1/topcities/150?apikey=kRK8UAPHaOphrB82Ida62hMIdFnt36yB
// 2. Возможность выбора города из списка для получения погоды
// 3. Получение погоды с https://developer.accuweather.com/accuweather-current-conditions-api/apis/get/currentconditions/v1/%7BlocationKey%7D

public class WebClientExample {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("https://dataservice.accuweather.com/");
        TopcitiesRoot[] accuWeatherTopCities = webClient.get()
            .uri(uriBuilder -> uriBuilder
                .pathSegment("locations", "v1", "topcities", "{count}")
                .queryParam("apikey", "kRK8UAPHaOphrB82Ida62hMIdFnt36yB")
                .build(150))
            .retrieve()
            .bodyToMono(TopcitiesRoot[].class)
            .block();
        System.out.println(accuWeatherTopCities);
    }

}
