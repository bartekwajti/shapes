package com.vaytee.shapes.figures;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by Admin on 2017-07-20.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "_circle"),
        @JsonSubTypes.Type(value = Square.class, name = "_square"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "_rectangle")
})
@Document(collection="figures_collection")
@RestResource(path="figures")
public abstract class Figure {

    @Getter
    @Setter
    @Id public String id;

    @Getter
    @Setter
    public Integer areaHitCounter = 0;

    public abstract double area();

    public abstract String getType();

    public abstract void isValid();
}
