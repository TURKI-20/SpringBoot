package com.example.userday8.Advice;

import com.example.userday8.Dto.ApiResponse;
import com.example.userday8.Exception.ApiException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class UserAdvice {



        @ExceptionHandler(value = ApiException.class)
        public ResponseEntity ApiException(ApiException o)

        {
            return ResponseEntity.status(400).body(o.getMessage());
        }

        @ExceptionHandler(value = ConstraintViolationException.class)
        public ResponseEntity ConstraintViolationException(ConstraintViolationException e){
            String message=e.getMessage();
            return ResponseEntity.status(400).body(message);
        }

        @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
        public ResponseEntity<ApiResponse> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
            String message=e.getMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        @ExceptionHandler(value = DataIntegrityViolationException.class)
        public ResponseEntity<ApiResponse> DataIntegrityViolationException(DataIntegrityViolationException e){
            String message=e.getMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        @ExceptionHandler(value = EntityNotFoundException.class)
        public ResponseEntity<ApiResponse> EntityNotFoundException(EntityNotFoundException e) {
            String message = e.getMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        @ExceptionHandler(value = MethodArgumentNotValidException.class)
        public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
            String message = e.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        @ExceptionHandler(value = HttpMessageNotReadableException.class)
        public ResponseEntity<ApiResponse> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
            String message = e.getMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
}
