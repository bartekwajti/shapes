package com.vaytee.shapes;

import com.vaytee.shapes.figures.model.Figure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Admin on 2017-07-20.
 */
public interface FiguresRepository extends MongoRepository<Figure, String> {
    Figure findById(@Param("id") String id);
}
