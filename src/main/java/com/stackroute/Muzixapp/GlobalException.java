package com.stackroute.Muzixapp;
import com.stackroute.Muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.Muzixapp.exception.TrackNotFoundException;
import com.stackroute.Muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.Muzixapp.exception.TrackAlreadyExistsException;
import com.stackroute.Muzixapp.exception.TrackNotFoundException;
import org.h2.engine.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Track;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(TrackNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionResponse handleResourceNotFound(final TrackNotFoundException exception,
                                                                  final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());

        return error;
    }

    @ExceptionHandler(TrackAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ExceptionResponse handleException(final TrackAlreadyExistsException exception,
                                                           final HttpServletRequest request) {

        ExceptionResponse error = new ExceptionResponse();
        error.setErrorMessage(exception.getMessage());
        error.callerURL(request.getRequestURI());

        return error;
    }


}