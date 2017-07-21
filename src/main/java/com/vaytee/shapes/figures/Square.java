package com.vaytee.shapes.figures;

import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;
/**
 * Created by Admin on 2017-07-20.
 */
public class Square extends Figure {

    @Getter
    @Setter
    public double side;



    public Square(double side) {
        this.side = side;
    }

    public Square() {};

    @Override
    public double area() {
        return side*side;
    }

    @Override
    public String getType() {
        return "_square";
    }
}
