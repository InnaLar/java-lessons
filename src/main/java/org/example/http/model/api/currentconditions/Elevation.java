package org.example.http.model.api.currentconditions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Elevation {
    @JsonProperty("Imperial")
    private Imperial imperial;
    @JsonProperty("Metric")
    private Metric metric;
}
