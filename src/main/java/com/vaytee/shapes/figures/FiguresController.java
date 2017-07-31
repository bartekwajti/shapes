package com.vaytee.shapes.figures;

import com.vaytee.shapes.AuthenticatedUser;
import com.vaytee.shapes.figures.model.Figure;
import com.vaytee.shapes.figures.model.Result;
import com.vaytee.shapes.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Admin on 2017-07-20.
 */
@RestController
@RequestMapping("/figures")
public class FiguresController {


    @Autowired
    private FiguresService figuresService;

    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/{id}/area", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> figureArea(@AuthenticatedUser User user,
                                             @PathVariable String id) {

        Optional<Figure> figureOptional = figuresService.findByIdAndUser(id, user.getUsername());
        if (figureOptional.isPresent()) {
            Figure figure = figureOptional.get();
            historyService.save(historyService.createHistoryItemFromFigure(figure));
            Double area = figure.area();
            return ResponseEntity.ok(new Result(area));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/area")
    public ResponseEntity<Result> allFiguresArea(@AuthenticatedUser User user) {
        List<Figure> figures = figuresService.findAllByUser(user.getUsername());
        Double result = figures.stream()
                .mapToDouble(f -> f.area()).sum();
        return ResponseEntity.ok(new Result(result));
    }

    @GetMapping
    public ResponseEntity<Page<Figure>> listFigures(
            @AuthenticatedUser User user,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20") Integer size) {

        Map<String, Page<Figure>> map = new HashMap<>();
        PageRequest pageRequest = new PageRequest(page, size);
        Page<Figure> result = figuresService.findAllByUser(user.getUsername(), pageRequest);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Figure> addFigure(@RequestBody @Valid Figure figure) {
        figuresService.save(figure);
        return ResponseEntity.ok(figure);
    }
}
