package com.anaxim.axmCarService.exceptions;

import com.anaxim.axmCarService.security.utils.HttpResponse;
import jakarta.persistence.NonUniqueResultException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.anaxim.axmCarService.exceptions.ExceptionConstant.INCORRECT_CREDENTIALS;

@RestControllerAdvice
public class ExceptionsHandling implements ErrorController {



    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HttpResponse> badCredentialsException(){


        return createHttpResponse(HttpStatus.BAD_REQUEST,INCORRECT_CREDENTIALS);
    }

    @ExceptionHandler(UsernameExistException.class)
    public ResponseEntity<HttpResponse> usernameExistException(UsernameExistException ex){
           String message;
           if(StringUtils.hasLength(ex.getMessage())){
               message = ex.getMessage();
           }else{ message = ExceptionConstant.USER_EXIST_MSG;}

        return createHttpResponse(HttpStatus.CONFLICT,message);
    }


    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<HttpResponse> emailExistException(EmailExistException ex){
        String message;
        if(StringUtils.hasLength(ex.getMessage())){
            message = ex.getMessage();
        }else{ message = ExceptionConstant.USER_EXIST_MSG;}

        return createHttpResponse(HttpStatus.CONFLICT,message);
    }

    @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<HttpResponse> nonUniqueResultException(NonUniqueResultException ex){
        String message;
        if(StringUtils.hasLength(ex.getMessage())){
            message = ex.getMessage();
        }else{ message = ExceptionConstant.USER_EXIST_MSG;}

        return createHttpResponse(HttpStatus.MULTIPLE_CHOICES,message);
    }

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message){

        HttpResponse httpResponse = new HttpResponse(httpStatus.value(),httpStatus,httpStatus.getReasonPhrase(),message.toUpperCase());

        return new ResponseEntity<>(httpResponse,httpStatus);




    }






}
