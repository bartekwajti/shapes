package com.vaytee.shapes;

import com.vaytee.shapes.figures.Figure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Admin on 2017-07-20.
 */
public interface FiguresRepository extends MongoRepository<Figure, String> {
    Figure findById(@Param("id") String id);

    //List<Figure> findByLastName(@Param("name") String name);
}
