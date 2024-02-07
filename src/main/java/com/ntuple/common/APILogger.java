package com.ntuple.common;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.RequestMethod;

@Log4j2
public class APILogger {

    private static final String MESSAGE_TEMPLATE_FOR_API_INFO_REQ_RES = "{} : {} , userInfo {} ,request {} , response {}";
    private static final boolean ENABLE_DEBUG = true;

    private static final boolean ENABLE_TRACE = true;

    private final Logger logger;

    public APILogger(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    /**
     * Log api info with params by format: yyyy-MM-dd hh:mm:ss [thread-name] TRACE
     * packageName.ClassName: "requestMethod apiName message objectPramList(json)"
     *
     * @param method   method
     * @param api      api
     * @param request  request
     * @param response response
     */
    public void logApi(RequestMethod method, String api, Object request, Object response) {
        try {
            log(LogLevel.DEBUG, MESSAGE_TEMPLATE_FOR_API_INFO_REQ_RES, method, api, "AuthUtils.getUserId()",
                    StringUtils.getJSON(request), StringUtils.getJSON(response));
        } catch (Exception e) {
            log(LogLevel.DEBUG, MESSAGE_TEMPLATE_FOR_API_INFO_REQ_RES, method, api, request, response);
        }
    }

    public void log(LogLevel level, String format, Object... params) {
        try {
            switch (level) {
                case TRACE -> {
                    if (ENABLE_TRACE) {
                        logger.trace(format, params);
                    }
                }
                case DEBUG -> {
                    if (ENABLE_DEBUG) {
                        logger.debug(format, params);
                    }
                }
                case INFO -> {
                    logger.info(format, params);
                    log.info(format, params);
                }
                case WARN -> {
                    logger.warn(format, params);
                    log.warn(format, params);
                }
                case ERROR -> {
                    logger.error(format, params);
                    log.error(format, params);
                }
                case FATAL -> {
                    logger.error("FATAL ERROR: " + format, params);
                    log.error("FATAL ERROR: " + format, params);
                }
                default -> {
                    logger.info(format, params);
                    log.info(format, params);
                }
            }
        } catch (Exception e) {
            logError(e.getMessage());
        }
    }


    /**
     * Log error by format: yyyy-MM-dd hh:mm:ss [thread-name] ERROR packageName.ClassName: Message
     *
     * @param message message
     */
    public void logError(String message) {
        log(LogLevel.ERROR, getLineInfo() + ": " + message);
    }

    private String getLineInfo() {
        return "[" + Thread.currentThread().getStackTrace()[3].getMethodName() + ":"
                + Thread.currentThread().getStackTrace()[3].getLineNumber() + "]";
    }
}
