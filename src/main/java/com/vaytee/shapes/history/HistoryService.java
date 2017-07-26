package com.vaytee.shapes.history;

import com.vaytee.shapes.figures.model.Figure;
import com.vaytee.shapes.history.model.HistoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public HistoryItem createHistoryItemFromFigure(Figure figure) {
        HistoryItem historyItem = new HistoryItem(System.currentTimeMillis(),
                figure.getId(), figure.area());
        return historyItem;
    }

    public Page<HistoryItem> findAll(PageRequest pageRequest) {
        return historyRepository.findAll(pageRequest);
    }

}
