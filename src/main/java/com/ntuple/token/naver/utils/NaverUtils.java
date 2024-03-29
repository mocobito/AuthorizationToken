package com.ntuple.token.naver.utils;

import com.ntuple.common.library.BCrypt;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Component
public class NaverUtils {

    /**
     * @param clientId
     * @param clientSecret
     */
    public  String generateSignature(String clientId, String clientSecret, long timestamp) {
        String password = clientId + "_" + timestamp;
        // bcrypt 해싱
        String hashedPw = BCrypt.hashpw(password, clientSecret);
        // base64 인코딩
        return Base64.getUrlEncoder().encodeToString(hashedPw.getBytes(StandardCharsets.UTF_8));
    }
}

