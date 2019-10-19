package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.exceptions.GameStoreNotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class GameStoreExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public VndErrors handleValidationError(MethodArgumentNotValidException e, WebRequest req) {
        // BindingResult holds the validation errors
        BindingResult result = e.getBindingResult();
        // Validation errors are stored in FieldError objects
        List<FieldError> fieldErrors = result.getFieldErrors();
        // Translate the FieldErrors to VndErrors
        List<VndErrors.VndError> vndErrorList = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            VndErrors.VndError vndError = new VndErrors.VndError(req.toString(), fieldError.getField() + ": " + fieldError.getDefaultMessage());
            vndErrorList.add(vndError);
        }

        // Wrap all of the VndError objects in a VndErrors object
        return new VndErrors(vndErrorList);
    }

   @ExceptionHandler(value = {GameStoreNotFoundException.class})
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public ResponseEntity<VndErrors> notFoundException(GameStoreNotFoundException e, WebRequest request) {
            VndErrors error = new VndErrors(request.toString(), "Richard's Message: Not found : " + e.getMessage());
            ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
            return responseEntity;
        }

}