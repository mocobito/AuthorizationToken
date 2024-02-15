package com.ntuple.token.naver.service;

import com.ntuple.token.coupang.model.NaverDto;
import com.ntuple.token.naver.utils.NaverUtils;
import org.springframework.stereotype.Service;


@Service
public class NaverService {
    private final NaverUtils utils;


    public NaverService(NaverUtils utils) {
        this.utils = utils;
    }

    //    public ResponseEntity<APIResponse> getAuthorization(CoupangDto.Request req) throws URISyntaxException {
//        CoupangDto.Response response = new CoupangDto.Response();
//        response.setAuthorization(utils.authorizationGenerate(req.getMethod(), req.getUri(), req.getSecretKey(), req.getAccessKey()));
//
//        return ResponseEntity.ok(APIResponseBuilder.buildResponse(ResultMessages.API_SUCCESS, response));
//    }
    public Object generateSignature(NaverDto.Request req) {
        NaverDto.Response response = new NaverDto.Response();
        response.setAuthorization(utils.generateSignature(req.getClientId(), req.getClientSecret()));
        return response;
    }
}
