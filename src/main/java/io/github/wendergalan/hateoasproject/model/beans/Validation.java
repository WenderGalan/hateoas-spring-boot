package io.github.wendergalan.hateoasproject.model.beans;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Validation {
    private String campo;
    private String mensagem;
}
