package io.github.wendergalan.personapi.helper;

import io.github.wendergalan.personapi.model.beans.Validation;
import org.springframework.validation.*;

import javax.validation.constraints.NotNull;
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
    public static List<Validation> criarListaDeErrosDaValidacao(List<ObjectError> erros) {
        List<Validation> lista = new ArrayList<>();
        if (erros != null && !erros.isEmpty()) {
            for (ObjectError error : erros)
                lista.add(Validation.builder().field(((FieldError) error).getField()).message(error.getDefaultMessage()).build());
        }
        return lista;
    }

    /**
     * É necessário rodar o validar Entidade novamente para recriar o Binding Result,
     * devido o Binding Result ser uma interface e ter uma coleção que não pode ser alterada.
     * Link para o relato do problema:
     * https://stackoverflow.com/questions/12514587/spring-how-to-remove-a-fielderror-from-a-bindingresult
     *
     * @param validator
     * @param object
     * @return
     */
    public static BindingResult validarEntidade(@NotNull Validator validator, @NotNull Object object) {
        DataBinder binder = new DataBinder(object);
        BindingResult bindingResult = binder.getBindingResult();
        validator.validate(object, bindingResult);
        return bindingResult;
    }
}
