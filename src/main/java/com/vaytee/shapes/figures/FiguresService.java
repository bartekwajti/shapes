package com.vaytee.shapes.figures;

import com.vaytee.shapes.figures.model.Figure;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 2017-07-25.
 */
@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE, onConstructor = @__(@Autowired))
public class FiguresService {

    @NonNull
    FiguresRepository repository;

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

    public void deleteAll() {
        repository.deleteAll();
    }

    public List<Figure> findAllByUser(String user) {
        return repository.findAllByUser(user);
    }

    public Page<Figure> findAllByUser(String user, PageRequest pageRequest) {
        return repository.findAllByUser(user, pageRequest);
    }

    public Optional<Figure> findByIdAndUser(String id, String user) {
        return Optional.ofNullable(repository.findByIdAndUser(id, user));
    }
}
