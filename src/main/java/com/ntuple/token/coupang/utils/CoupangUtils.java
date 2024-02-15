package com.ntuple.token.coupang.utils;

import com.coupang.openapi.sdk.Hmac;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Component
public class CoupangUtils {

    /**
     * @param method
     * @param path
     * @param secretKey
     * @param accessKey
     */
    public String authorizationGenerate(String method, String path, String secretKey, String accessKey) throws URISyntaxException {
        return Hmac.generate(method, new URIBuilder()
                .setPath(path).build().toString(), secretKey, accessKey);
    }


}
