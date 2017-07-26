package com.vaytee.shapes.history.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by Admin on 2017-07-22.
 */
@Document
@Getter
public class HistoryItem {

    @Id
    private String id;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private final LocalDateTime timestamp;
    private final String figureId;
    private final Double result;

    @JsonCreator
    public HistoryItem(@JsonProperty("timestamp") LocalDateTime timestamp,
                       @JsonProperty("figureId") String figureId,
                       @JsonProperty("result") double result) {
        this.timestamp = timestamp;
        this.figureId = figureId;
        this.result = result;
    }
}
