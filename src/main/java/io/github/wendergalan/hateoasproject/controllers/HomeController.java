package io.github.wendergalan.hateoasproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * hateoas-project
 * Todos os direitos reservados ©
 * ***********************************************
 * Nome do arquivo: HomeController.java
 * Criado por : Wender Galan Benage
 * Data da criação : 25/11/19
 * Observação :
 * ***********************************************
 */
@RestController
public class HomeController {

    /**
     * Redirect de port application to swagger ui
     * @return ModalAndView
     */
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("redirect:" + "swagger-ui.html");
    }
}
