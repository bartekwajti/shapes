package com.vaytee.shapes.history;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Admin on 2017-07-22.
 */

public class HistoryItem {

    @Id private String id;
    public long timestamp;
    public String figureId;
    public double result;

    public HistoryItem(long timestamp, String figureId, double result) {
        this.timestamp = timestamp;
        this.figureId = figureId;
        this.result = result;
    }
}
