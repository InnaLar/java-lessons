package org.example.http.client;

import lombok.RequiredArgsConstructor;
import org.example.http.model.api.barbecueWeather.OutdoorRoot;
import org.example.http.model.api.currentconditions.CurrentConditionsRoot;
import org.example.http.model.api.locations.TopcitiesRoot;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class AccuweatherClient {
    private final WebClient webClient;
    private static final String APIKEY = "apikey";
    private static final String API_KEY_VALUE = "dyKHmZXCEt9IF3mdJIjDuxZtpArMOLVv";
    private static final int BARBECUE_GROUP_ID = 6;

    public TopcitiesRoot[] getTopcitiesRoot() {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .pathSegment("locations", "v1", "topcities", "{count}")
                .queryParam(APIKEY, API_KEY_VALUE)
                .build(150))
            .retrieve()
            .bodyToMono(TopcitiesRoot[].class)
            .block();
    }

    public CurrentConditionsRoot[] getCurrentConditionsRoot(final String id) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .pathSegment("currentconditions", "v1", "{locationKey}")
                .queryParam(APIKEY, API_KEY_VALUE)
                .build(id))
            .retrieve()
            .bodyToMono(CurrentConditionsRoot[].class)
            .block();
    }

    public OutdoorRoot[] getOutdoorRoot(final String id) {
        return webClient.get()
            .uri(uriBuilder -> uriBuilder
                .pathSegment("indices", "v1", "daily", "1day", "{locationKey}", "groups", "{ID}")
                .queryParam(APIKEY, API_KEY_VALUE)
                .build(id, BARBECUE_GROUP_ID)
            )
            .retrieve()
            .bodyToMono(OutdoorRoot[].class)
            .block();
    }
}
