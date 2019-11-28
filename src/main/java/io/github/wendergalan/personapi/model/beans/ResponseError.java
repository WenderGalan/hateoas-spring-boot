package io.github.wendergalan.personapi.model.beans;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The type Response error.
 */
@Data
@AllArgsConstructor
public class ResponseError {
    private String message;
}
