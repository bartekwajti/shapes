package com.vaytee.shapes.history;

import com.vaytee.shapes.history.model.HistoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 2017-07-22.
 */
@RestController
@RequestMapping("history")
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping
    public ResponseEntity<Map<String, Page<HistoryItem>>> listFigures(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20") Integer size) {

        Map<String, Page<HistoryItem>> map = new HashMap<>();
        PageRequest pageRequest = new PageRequest(page, size);
        map.put("history", historyService.findAll(pageRequest));
        return ResponseEntity.ok(map);
    }
}
