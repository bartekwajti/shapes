package com.vaytee.shapes.figures.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Admin on 2017-07-21.
 */
@Value
public class Rectangle extends Figure {

    @Min(0)
    @NotNull
    private final Double a;

    @Min(0)
    @NotNull
    private final Double b;

    @JsonCreator
    public Rectangle(@JsonProperty("a") Double a, @JsonProperty("b") Double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public String getType() {
        return "_rectangle";
    }
}
