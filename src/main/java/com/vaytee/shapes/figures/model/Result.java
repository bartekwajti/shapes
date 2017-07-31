package com.vaytee.shapes.figures.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.NotNull;

/**
 * Created by Admin on 2017-07-26.
 */
@Value
public class Result {
    @NotNull
    private final Double area;

    public Result(@JsonProperty("area") Double area) {
        this.area = area;
    }
}
