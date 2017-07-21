package com.vaytee.shapes.figures;

import com.vaytee.shapes.InvalidFigurePropertiesException;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Admin on 2017-07-21.
 */
public class Rectangle extends Figure {
    @Getter
    @Setter
    public double a;

    @Getter
    @Setter
    public double b;


    public Rectangle() {};

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.isValid();
    }

    @Override
    public double area() {
        return a*b;
    }

    @Override
    public String getType() {
        return "_rectangle";
    }

    @Override
    public void isValid() {
        if(a <= 0 || b <= 0)
            throw new InvalidFigurePropertiesException("Invalid properties for figure of type " + this.getType() );
    }
}
