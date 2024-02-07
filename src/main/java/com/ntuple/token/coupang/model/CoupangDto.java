package com.ntuple.token.coupang.model;

import lombok.Data;

public class CoupangDto {
    @Data
    public static class Request{
        private String method;
        private String uri;
        private String secretKey;
        private String accessKey;
    }
    @Data
    public static class Response{
        private String authorization;
    }
}
