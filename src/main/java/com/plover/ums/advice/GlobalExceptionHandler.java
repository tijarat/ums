package com.plover.ums.advice;

import com.plover.ums.response.ApiResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleInvalidFormat(HttpMessageNotReadableException ex)
    {
        String message = "Invalid input type";
        Throwable cause = ex.getMostSpecificCause();
        if (cause instanceof InvalidFormatException ife) 
        {
            String fieldName = ife.getPathReference();
            String targetType = ife.getTargetType() != null ? ife.getTargetType().getSimpleName() : "UnknownType";
            message = String.format("Field '%s' must be of type %s", fieldName, targetType);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(HttpStatus.BAD_REQUEST.value(), message));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse> handleAccessDenied(AccessDeniedException ex, HttpServletRequest request) 
    {
        String path = request.getRequestURI();
        String message = String.format("You do not have the required privilege to access '%s'. Please check your rights or roles.", path );
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse(HttpStatus.FORBIDDEN.value(), message));
     }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse> handleAuthenticationException(AuthenticationException ex) 
    {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(HttpStatus.UNAUTHORIZED.value(), "Authentication failed: " + ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleAll(Exception ex) 
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error"));
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse> handleNoHandlerFound(NoHandlerFoundException ex) 
    {
        String message = String.format("No method/function found for URL '%s'", ex.getRequestURL());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), message));
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) 
    {
        if (ex.getRequiredType() != null && ex.getRequiredType().equals(Long.class)) 
        {
            String message = String.format("No method/function found for URL '%s'", ex.getValue());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(HttpStatus.NOT_FOUND.value(), message));
        }

        String message = String.format("Parameter '%s' must be of type %s", ex.getName(),ex.getRequiredType().getSimpleName());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(HttpStatus.BAD_REQUEST.value(), message));
    }    
    
}
