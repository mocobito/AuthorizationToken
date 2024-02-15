package com.ntuple.common;

import com.ntuple.common.json.Result;
import com.ntuple.common.json.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestControllerAdvice
@Slf4j
public class RestControllerAdvice {



    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<?> handleException(HttpServletRequest req, Exception e) {
        log.error("EXCEPTION : {}", req.getRequestURI(), e);
        String message = "[Exception]" + e.getMessage();
        if (message.length() > 50) {
            message = message.substring(0, 50) + "...";
        }
        return new ResultData<>(Result.ERROR, message, null);
    }
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultData<?> handleIllegalArgumentException(HttpServletRequest req, Exception e) {
        String message = "[INVALID_REQUEST]" + e.getMessage();
        if (message.length() > 50) {
            message = message.substring(0, 50) + "...";
        }
        log.warn("INVALID_REQUEST : {} | {}", req.getRequestURI(), message);
        return new ResultData<>(Result.PARAM_ERROR, message, null);
    }
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultData<?> handleMethodArgumentNotValidException(HttpServletRequest req,
                                                               BindException e) {
        log.error("INVALID_REQUEST : {}", req.getRequestURI(), e);
        String errors = e.getBindingResult().getFieldErrors().stream()
                .map(x -> x.getField() + ":" + x.getDefaultMessage())
                .collect(Collectors.joining(", "));
        log.warn("INVALID_REQUEST : {} | {}", req.getRequestURI(), errors);
        return new ResultData<>(Result.PARAM_ERROR, errors, null);
    }

}
