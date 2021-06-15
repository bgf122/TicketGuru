package com.kineesio.TicketGuru.web.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        return "Pyydettyä resurssia ei löydy.\n" + request.getRequestURL();
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public String handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request) {
        return "Sinulla ei ole oikeutta tähän toimenpiteeseen.\n" + request.getRequestURL();
    }

    // Tarkistaa, että JSON on oikeamuotoista
    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleBadJSON(JsonProcessingException jp, HttpServletRequest request) {
        return "Syötteessä oli jotain vikaa. JSON ei kelvannut";
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public String handleUsernameNotFoundException(HttpServletRequest request, UsernameNotFoundException ex) {
        return "Käyttäjätunnus tai salasana oli väärin.";
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String handleUnauthorized(HttpServletRequest request, HttpClientErrorException ex) {
        return "Sinulla ei ole oikeutta tähän toimenpiteeseen.\n" + request.getRequestURL();
    }
}
