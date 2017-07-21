package com.vaytee.shapes.figures;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Persistent;

/**
 * Created by Admin on 2017-07-21.
 */
@Persistent
public class Circle extends Figure {

    @Getter
    @Setter
    public double radius;



    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {};

    @Override
    public double area() {
        return 3.14*radius*radius;
    }

    @Override
    public String getType() {
        return "_circle";
    }
}