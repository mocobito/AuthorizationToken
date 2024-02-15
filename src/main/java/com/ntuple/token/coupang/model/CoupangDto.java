package com.ntuple.token.coupang.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class CoupangDto {
    @Data
    public static class Request{
        @NotBlank(message = "Method is mandatory")
        private String method;
        @NotBlank(message = "Uri is mandatory")
        private String uri;
        @NotBlank(message = "SecretKey is mandatory")
        private String secretKey;
        @NotBlank(message = "AccessKey is mandatory")
        private String accessKey;
    }
    @Data
    public static class Response{
        private String authorization;
    }
}
