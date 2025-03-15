package org.acme;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CalculationRequest(
    @JsonProperty("operator1") String operator1,
    @JsonProperty("operator2") String operator2,
    @JsonProperty("operation") String operation
) {} 