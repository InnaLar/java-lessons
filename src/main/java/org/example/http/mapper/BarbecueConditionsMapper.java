package org.example.http.mapper;

import org.example.http.model.api.barbecueweather.OutdoorRoot;
import org.example.http.model.entity.OutdoorConditions;

public class BarbecueConditionsMapper {
    public OutdoorConditions toOutdoorConditions(final OutdoorRoot outdoorRoot) {
        return OutdoorConditions.builder()
            .name(outdoorRoot.getName())
            .value(outdoorRoot.getValue())
            .category(outdoorRoot.getCategory())
            .build();
    }
}
