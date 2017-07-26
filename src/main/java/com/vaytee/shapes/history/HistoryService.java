package com.vaytee.shapes.history;

import com.vaytee.shapes.figures.model.Figure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017-07-26.
 */
@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public void save(HistoryItem historyItem) {
        historyRepository.save(historyItem);
    }

    public HistoryItem createFromFigure(Figure figure) {
        HistoryItem historyItem = new HistoryItem(System.currentTimeMillis(),
                figure.getId(), figure.area());
        return historyItem;
    }

}
