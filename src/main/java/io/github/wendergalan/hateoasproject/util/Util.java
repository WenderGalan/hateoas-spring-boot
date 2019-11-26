package io.github.wendergalan.hateoasproject.util;

import io.github.wendergalan.hateoasproject.model.beans.Validation;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class Util {

    /**
     * @return
     */
    public static List<Validation> criarListaDeErrosDaValidacao(List<ObjectError> erros) {
        List<Validation> lista = new ArrayList<>();
        if (erros != null && !erros.isEmpty()) {
            for (ObjectError error : erros)
                lista.add(Validation.builder().campo(error.getObjectName()).mensagem(error.getDefaultMessage()).build());
        }
        return lista;
    }
}
