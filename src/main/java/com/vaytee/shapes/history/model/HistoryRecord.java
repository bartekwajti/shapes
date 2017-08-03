package com.vaytee.shapes.history.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaytee.shapes.domain.AbstractAuditingEntity;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Admin on 2017-07-22.
 */
@Document
@Getter
public class HistoryRecord extends AbstractAuditingEntity {

    private final String figureId;
    private final Double result;

    @JsonCreator
    public HistoryRecord(@JsonProperty("figureId") String figureId,
                         @JsonProperty("result") double result) {
        this.figureId = figureId;
        this.result = result;
    }
}
