package com.ntuple.token.naver.utils;

import com.coupang.openapi.sdk.Hmac;
import com.ntuple.common.library.BCrypt;
import org.apache.http.client.utils.URIBuilder;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Base64;


@Component
public class NaverUtils {

    /**
     * @param clientId
     * @param clientSecret
     */
    public  String generateSignature(String clientId, String clientSecret) {
        long timestamp = System.currentTimeMillis();
        String password = clientId + "_" + timestamp;
        // bcrypt 해싱
        String hashedPw = BCrypt.hashpw(password, clientSecret);
        // base64 인코딩
        return Base64.getUrlEncoder().encodeToString(hashedPw.getBytes(StandardCharsets.UTF_8));
    }
}

