package com.vaytee.shapes.figures.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vaytee.shapes.domain.AbstractAuditingEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Admin on 2017-07-20.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "_circle"),
        @JsonSubTypes.Type(value = Square.class, name = "_square"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "_rectangle")
})
@Document(collection = "figures")
@Getter
@Setter
public abstract class Figure extends AbstractAuditingEntity {

    public abstract Double area();

    public String getAreaLink() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return "http://localhost:8080/figures/" + getId() + "/area";
    }
}
