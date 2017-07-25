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
public class Circle extends Figure {

    @Min(0)
    @NotNull
    private final Double radius;

    @JsonCreator
    public Circle(@JsonProperty("radius") double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getType() {
        return "_circle";
    }
}