package com.vaytee.shapes.figures;

import com.vaytee.shapes.InvalidFigurePropertiesException;
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
//        if(side <= 0)
//            throw new InvalidFigurePropertiesException("");
        this.side = side;
        this.isValid();
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

    @Override
    public void isValid() {
        if(side <= 0)
            throw new InvalidFigurePropertiesException("Invalid properties for figure of type " + this.getType() );
    }
}
