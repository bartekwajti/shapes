package com.vaytee.shapes.history;

import com.vaytee.shapes.figures.model.Figure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017-07-22.
 */
//@Component
//public class HistoryResourceProcessor implements ResourceProcessor<Resource<HistoryItem>> {
//
////    @Autowired
////    EntityLinks entityLinks;
////
////    @Override
////    public Resource<HistoryItem> process(Resource<HistoryItem> resource) {
////        HistoryItem historyItem = resource.getContent();
////        LinkBuilder linkForSingleResource = entityLinks.linkForSingleResource(Figure.class, historyItem.figureId);
////        resource.add(linkForSingleResource.withRel("figure"));
////        return resource;
////    }
//}
