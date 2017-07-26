package com.vaytee.shapes;

import com.vaytee.shapes.figures.FiguresRepository;
import com.vaytee.shapes.figures.model.Circle;
import com.vaytee.shapes.figures.model.Figure;
import com.vaytee.shapes.figures.model.Rectangle;
import com.vaytee.shapes.figures.model.Square;
import com.vaytee.shapes.history.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Admin on 2017-07-26.
 */
@Service
public class InitService {

    @Autowired
    private FiguresRepository repository;

    @Autowired
    HistoryRepository historyRepository;


    @PostConstruct
    public void init() {
        historyRepository.deleteAll();

        repository.deleteAll();

        repository.save(new Square(5d));
        repository.save(new Square(6d));
        repository.save(new Circle(4d));
        repository.save(new Circle(10d));

        repository.save(new Rectangle(5d, 10d));

        System.out.println("Figures found with findAll():");
        System.out.println("-------------------------------");
        for (Figure figure : repository.findAll()) {
            System.out.println(figure);
        }
        System.out.println();
    }
}
