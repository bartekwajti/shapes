package com.vaytee.shapes.figures;

import com.vaytee.shapes.figures.model.Figure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 2017-07-25.
 */
@Service
public class FiguresService {
    @Autowired
    private FiguresRepository repository;

    public void save(Figure figure) {
        repository.save(figure);
    }

    public Optional<Figure> find(String id) {
        return Optional.of(repository.findById(id));
    }

    public List<Figure> findAll() {
        return repository.findAll();
    }

    public Page<Figure> findAll(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

}