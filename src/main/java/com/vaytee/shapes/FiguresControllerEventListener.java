package com.vaytee.shapes;

import com.vaytee.shapes.figures.Figure;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017-07-21.
 */
@Component
public class FiguresControllerEventListener extends AbstractRepositoryEventListener<Figure> {
    @Override
    protected void onBeforeCreate(Figure entity) {
        super.onBeforeCreate(entity);
        entity.isValid();
    }
}
