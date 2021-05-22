package com.issat.portail.config;

import com.issat.portail.exception.BadRequest;
import com.issat.portail.utils.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ResponseDTO> badrequest(BadRequest badRequest){
        return ResponseEntity.status(400).body(new ResponseDTO(badRequest.getMessage(),400,"BadRequest") );
    }
}
