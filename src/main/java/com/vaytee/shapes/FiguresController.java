package com.vaytee.shapes;

import com.vaytee.shapes.figures.model.Figure;
import com.vaytee.shapes.history.HistoryItem;
import com.vaytee.shapes.history.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 2017-07-20.
 */
@RestController
@ExposesResourceFor(Figure.class)
@RequestMapping("/figures")
public class FiguresController {

    @Autowired
    private FiguresRepository repository;

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/{id}/area")
    public ResponseEntity<Double> figureArea(@PathVariable String id){
        Figure figure = repository.findById(id);
        if(figure != null) {

            long timestamp = System.currentTimeMillis();
            HistoryItem historyItem = new HistoryItem(timestamp, figure.getId(), figure.area() );
            historyRepository.save(historyItem);
            return ResponseEntity.ok(figure.area());
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/area")
    public  ResponseEntity<Double> allFiguresArea(){
        List<Figure> figures = repository.findAll();
        Double result = new Double(0);
        for(Figure f : figures) {
            result += f.area();
        }
        return ResponseEntity.ok(result);
    }
}
