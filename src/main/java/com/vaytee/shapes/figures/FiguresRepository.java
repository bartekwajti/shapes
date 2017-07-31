package com.vaytee.shapes.figures;

import com.vaytee.shapes.figures.model.Figure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Admin on 2017-07-20.
 */
public interface FiguresRepository extends MongoRepository<Figure, String> {
    Figure findById(@Param("id") String id);

    List<Figure> findAllByUser(@Param("user") String user);

    Page<Figure> findAllByUser(@Param("user") String user, Pageable pageable);

    Figure findByIdAndUser(@Param("id") String id, @Param("user") String user);
}
