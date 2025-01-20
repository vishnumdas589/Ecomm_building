package com.scalar.demo2.ControllerAdvice;

import com.scalar.demo2.dto.ErrorDTO;
import com.scalar.demo2.exceptions.prodNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(prodNotFoundException.class)
    public ResponseEntity<ErrorDTO> prodNotFoundExceptionHandler (Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setM(e.getMessage());
        ResponseEntity<ErrorDTO> responds = new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
        return responds;
    }
}
