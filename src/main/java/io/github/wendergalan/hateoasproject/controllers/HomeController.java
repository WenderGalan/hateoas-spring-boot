package io.github.wendergalan.hateoasproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * The type Home controller.
 */
@RestController
public class HomeController {

    /**
     * Redirect de port application to swagger ui
     *
     * @return ModalAndView model and view
     */
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("redirect:" + "swagger-ui.html");
    }
}
