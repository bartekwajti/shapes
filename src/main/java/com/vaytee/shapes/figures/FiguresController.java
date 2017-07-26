package com.vaytee.shapes.figures;

import com.vaytee.shapes.figures.model.Figure;
import com.vaytee.shapes.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    @ResponseBody
    public ResponseEntity<Result> figureArea(@PathVariable String id) {
        Optional<Figure> figureOptional = figuresService.find(id);
        if (figureOptional.isPresent()) {
            Figure figure = figureOptional.get();
            Double area = figure.area();
            historyService.save(historyService.createHistoryItemFromFigure(figure));
            return ResponseEntity.ok(new Result(area));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/area")
    public ResponseEntity<Result> allFiguresArea() {
        List<Figure> figures = figuresService.findAll();
        Double result = 0d;
        figures.stream()
                .mapToDouble(f -> f.area()).sum();
        return ResponseEntity.ok(new Result(result));
    }

    @GetMapping
    public ResponseEntity<Map<String, Page<Figure>>> listFigures(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20") Integer size) {

        Map<String, Page<Figure>> map = new HashMap<>();
        PageRequest pageRequest = new PageRequest(page, size);
        map.put("figures", figuresService.findAll(pageRequest));
        return ResponseEntity.ok(map);
    }

    @PostMapping
    public ResponseEntity<Figure> addFigure(@RequestBody @Valid Figure figure) {
        figuresService.save(figure);
        return ResponseEntity.ok(figure);
    }
}
