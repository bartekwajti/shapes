package com.vaytee.shapes.figures.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Admin on 2017-07-20.
 */
@Value
public class Square extends Figure {

    @Min(0)
    @NotNull
    private final Double side;

    public Square(@JsonProperty("side") Double side) {
        super();
        this.side = side;
    }

    @Override
    public Double area() {
        return side * side;
    }

    @Override
    public String getType() {
        return "_square";
    }
}
