package com.ntuple.token.coupang.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class NaverDto {
    @Data
    public static class Request {
        @NotBlank(message = "ClientId is mandatory")
        private String clientId;
        @NotBlank(message = "Client Secret is mandatory")
        private String clientSecret;
    }

    @Data
    public static class Response {
        private String authorization;
    }
}
