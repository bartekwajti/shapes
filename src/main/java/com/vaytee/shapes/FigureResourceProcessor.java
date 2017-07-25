package com.vaytee.shapes;

import com.vaytee.shapes.figures.model.Figure;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.*;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017-07-21.
 */
@Component
@RequiredArgsConstructor
public class FigureResourceProcessor implements ResourceProcessor<Resource<Figure>> {
    @Autowired EntityLinks entityLinks;

    @Override
    public Resource<Figure> process(Resource<Figure> resource) {
        Figure figure = resource.getContent();
        LinkBuilder linkForSingleResource =
                this.entityLinks.linkForSingleResource(Figure.class, figure.getId()).slash("area");
        resource.add(linkForSingleResource.withRel("area"));
        return resource;
    }
}
