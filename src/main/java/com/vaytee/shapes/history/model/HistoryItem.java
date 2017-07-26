package com.vaytee.shapes.history.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Admin on 2017-07-22.
 */
@Document
@Getter
public class HistoryItem {

    @Id
    private String id;

    private final Long timestamp;
    private final String figureId;
    private final Double result;

    @JsonCreator
    public HistoryItem(@JsonProperty("timestamp") Long timestamp,
                       @JsonProperty("figureId") String figureId,
                       @JsonProperty("result") double result) {
        this.timestamp = timestamp;
        this.figureId = figureId;
        this.result = result;
    }
}
