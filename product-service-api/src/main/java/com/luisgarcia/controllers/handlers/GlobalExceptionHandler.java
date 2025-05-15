package com.luisgarcia.controllers.handlers;

import com.luisgarcia.exceptions.ApplicationException;
import com.luisgarcia.exceptions.CategoryNotFoundException;
import com.luisgarcia.exceptions.ProductNotFoundException;
import com.luisgarcia.exceptions.UserNotAuthorizedException;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(UserNotAuthorizedException.class)
  ProblemDetail handlePUserNotAuthorizedException(UserNotAuthorizedException e) {
    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    problemDetail.setTitle("Customized User Not Authorized");
    problemDetail.setProperty("StackTrace", e.getStackTrace());
    problemDetail.setProperty("TimeStamp", Instant.now());
    return problemDetail;
  }

  @ExceptionHandler(CategoryNotFoundException.class)
  ProblemDetail handleCategoryNotFoundException(CategoryNotFoundException e) {
    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    problemDetail.setTitle("Customized Category Not Found");
    problemDetail.setProperty("StackTrace", e.getStackTrace());
    problemDetail.setProperty("TimeStamp", Instant.now());
    return problemDetail;
  }

  @ExceptionHandler(ProductNotFoundException.class)
  ProblemDetail handleProductNotFoundException(ProductNotFoundException e) {
    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
    problemDetail.setTitle("Customized Product Not Found");
    problemDetail.setProperty("StackTrace", e.getStackTrace());
    problemDetail.setProperty("TimeStamp", Instant.now());
    return problemDetail;
  }

  @ExceptionHandler(ApplicationException.class)
  ProblemDetail handleApplicationException(ApplicationException e) {
    ProblemDetail problemDetail =
        ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
    problemDetail.setTitle("Customized Internal Error");
    problemDetail.setProperty("StackTrace", e.getStackTrace());
    problemDetail.setProperty("TimeStamp", Instant.now());
    return problemDetail;
  }
}
