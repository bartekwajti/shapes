package com.vaytee.shapes;

import com.vaytee.shapes.figures.Figure;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.core.EvoInflectorRelProvider;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017-07-21.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FigureRelProvider extends EvoInflectorRelProvider {
    @Override
    public String getCollectionResourceRelFor(Class<?> type) {
        if(Figure.class.isAssignableFrom(type))
            return super.getCollectionResourceRelFor(Figure.class);
        return super.getCollectionResourceRelFor(type);
    }

    @Override
    public boolean supports(Class<?> delimiter) {
        return super.supports(delimiter);
    }

    @Override
    public String getItemResourceRelFor(Class<?> type) {
        if(Figure.class.isAssignableFrom(type))
            return super.getItemResourceRelFor(Figure.class);
        return super.getItemResourceRelFor(type);
    }
}
