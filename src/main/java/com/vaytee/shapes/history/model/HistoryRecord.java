package com.vaytee.shapes.history.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Admin on 2017-07-22.
 */
@Document
@Getter
public class HistoryRecord {

    @Id
    private String id;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @CreatedDate
    private LocalDateTime timestamp;

    @NotNull
    @CreatedBy
    private String user;

    private final String figureId;
    private final Double result;

    @JsonCreator
    public HistoryRecord(@JsonProperty("figureId") String figureId,
                         @JsonProperty("result") double result) {
        this.figureId = figureId;
        this.result = result;
    }
}
