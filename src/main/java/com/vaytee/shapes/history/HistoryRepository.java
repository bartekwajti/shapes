package com.vaytee.shapes.history;

import com.vaytee.shapes.history.model.HistoryRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Admin on 2017-07-22.
 */
public interface HistoryRepository extends MongoRepository<HistoryRecord, String> {

    Page<HistoryRecord> findAllByUser(@Param("user") String user, Pageable pageable);

}
