package com.cg.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.util.ErrorResponse;

@ControllerAdvice
public class BookCategoryControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(BookCategoryControllerAdvice.class);

  
    @ExceptionHandler(BookException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse adviceCartException(BookException e) {

        LOG.error("IllegalArgumentException occurred during fulfilment of request. Message:" + e.getMessage());

        return createErrorResponse(ErrorCode.INVALID_DATA.name().toLowerCase(), ErrorCode.INVALID_DATA.getMessage(e.getMessage()));
    }

    @ExceptionHandler(CategoryException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse adviceOrderException(CategoryException e) {

        LOG.error("IllegalArgumentException occurred during fulfilment of request. Message:" + e.getMessage());

        return createErrorResponse(ErrorCode.INVALID_DATA.name().toLowerCase(), ErrorCode.INVALID_DATA.getMessage(e.getMessage()));
    }



    private ErrorResponse createErrorResponse(String errorCode, String message) {
        return new ErrorResponse(errorCode, message);
    }

}