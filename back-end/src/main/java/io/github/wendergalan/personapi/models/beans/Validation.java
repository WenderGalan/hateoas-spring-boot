package io.github.wendergalan.personapi.models.beans;

import lombok.Builder;
import lombok.Data;

/**
 * The type Validation.
 */
@Data
@Builder
public class Validation {
    private String field;
    private String message;
}
