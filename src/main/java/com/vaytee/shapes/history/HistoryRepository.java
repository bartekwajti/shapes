package com.vaytee.shapes.history;

import com.vaytee.shapes.history.model.HistoryItem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Admin on 2017-07-22.
 */
public interface HistoryRepository extends MongoRepository<HistoryItem, String> {
}
