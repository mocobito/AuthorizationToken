package com.ntuple.token.coupang.service;

import com.ntuple.common.enums.ResultMessages;
import com.ntuple.common.resp.APIResponse;
import com.ntuple.common.resp.APIResponseBuilder;
import com.ntuple.token.coupang.model.CoupangDto;
import com.ntuple.token.coupang.utils.CoupangUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Service
public class CoupangService {
    private final CoupangUtils utils;


    public CoupangService(CoupangUtils utils) {
        this.utils = utils;
    }

//    public ResponseEntity<APIResponse> getAuthorization(CoupangDto.Request req) throws URISyntaxException {
//        CoupangDto.Response response = new CoupangDto.Response();
//        response.setAuthorization(utils.authorizationGenerate(req.getMethod(), req.getUri(), req.getSecretKey(), req.getAccessKey()));
//
//        return ResponseEntity.ok(APIResponseBuilder.buildResponse(ResultMessages.API_SUCCESS, response));
//    }
    public Object getAuthorization(CoupangDto.Request req) throws URISyntaxException {
        CoupangDto.Response response = new CoupangDto.Response();
        response.setAuthorization(utils.authorizationGenerate(req.getMethod(), req.getUri(), req.getSecretKey(), req.getAccessKey()));
        return response;
    }
}
