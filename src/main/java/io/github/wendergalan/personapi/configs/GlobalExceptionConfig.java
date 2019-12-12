package io.github.wendergalan.personapi.configs;


import io.github.wendergalan.personapi.models.beans.ResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * The type Global exception config.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionConfig {

    /**
     * Handle error generic response entity.
     *
     * @param ex         the ex
     * @param webRequest the web request
     * @return the response entity
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity handleErrorGeneric(Exception ex, WebRequest webRequest) {
        // Do Anything with webRequest
        log.error(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(new ResponseError("There was a server error and we are already checking. So Sorry."));
    }
}
