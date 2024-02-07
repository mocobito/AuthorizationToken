package com.ntuple.common;

import com.ntuple.common.json.Result;
import com.ntuple.common.json.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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
}
