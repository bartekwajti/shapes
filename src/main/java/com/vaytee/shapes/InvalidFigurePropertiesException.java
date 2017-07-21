package com.vaytee.shapes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Admin on 2017-07-21.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFigurePropertiesException extends RuntimeException {
    public InvalidFigurePropertiesException(String message) {
        super(message);
    }
}
