package com.vaytee.shapes.history;

import com.vaytee.shapes.figures.model.Figure;
import com.vaytee.shapes.history.model.HistoryRecord;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 2017-07-26.
 */
@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE, onConstructor = @__(@Autowired))
public class HistoryService {

    @NonNull
    HistoryRepository historyRepository;

    public void save(HistoryRecord historyRecord) {
        historyRepository.save(historyRecord);
    }

    public HistoryRecord createAndSaveHistoryRecord(Figure figure) {
        HistoryRecord record = createHistoryRecordFromFigure(figure);
        historyRepository.save(record);
        return record;
    }

    public Page<HistoryRecord> findAll(PageRequest pageRequest) {
        return historyRepository.findAll(pageRequest);
    }

    public Page<HistoryRecord> findAllByUser(String user, PageRequest pageRequest) {
        return historyRepository.findAllByUser(user, pageRequest);
    }

    public void deleteAll() {
        historyRepository.deleteAll();
    }

    private HistoryRecord createHistoryRecordFromFigure(Figure figure) {
        return new HistoryRecord(figure.getId(), figure.area());
    }
}
