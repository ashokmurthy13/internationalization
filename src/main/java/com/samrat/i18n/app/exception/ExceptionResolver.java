package com.samrat.i18n.app.exception;

import com.samrat.i18n.app.config.MessageSourceConfig;
import com.samrat.i18n.app.entity.RestException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import java.util.Locale;

@ControllerAdvice
public class ExceptionResolver {

    @Resource
    private MessageSource messageSource;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({MyCustomException.class, RuntimeException.class})
    public String resolveCustomException(MyCustomException e, Locale locale) {
        String errorMessage = messageSource.getMessage(e.getMessage(), e.getArgs(), locale);
        return errorMessage;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({RuntimeException.class})
    public RestException resolveException(Exception e) {
        RestException response = new RestException(e.getMessage());
        return response;
    }

}
