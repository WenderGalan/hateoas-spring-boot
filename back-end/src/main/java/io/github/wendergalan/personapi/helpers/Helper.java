package io.github.wendergalan.personapi.helpers;

import io.github.wendergalan.personapi.models.beans.Validation;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Util.
 */
public class Helper {

    /**
     * Criar lista de erros da validacao list.
     *
     * @param erros the erros
     * @return the list
     */
    public static List<Validation> createListOfErrorValidations(List<ObjectError> erros) {
        List<Validation> lista = new ArrayList<>();
        if (erros != null && !erros.isEmpty()) {
            for (ObjectError error : erros)
                lista.add(Validation.builder().field(((FieldError) error).getField()).message(error.getDefaultMessage()).build());
        }
        return lista;
    }
}
