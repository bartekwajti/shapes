package com.vaytee.shapes.figures;

import com.vaytee.shapes.InvalidFigurePropertiesException;
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
        this.isValid();
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

    @Override
    public void isValid() {
        if(radius <= 0)
            throw new InvalidFigurePropertiesException("Invalid properties for figure of type " + this.getType() );
    }
}