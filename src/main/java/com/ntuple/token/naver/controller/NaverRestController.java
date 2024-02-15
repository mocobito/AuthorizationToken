package com.ntuple.token.naver.controller;

import com.ntuple.common.APILogger;
import com.ntuple.common.Constant;
import com.ntuple.token.coupang.model.NaverDto;
import com.ntuple.token.naver.service.NaverService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = Constant.API_NAVER)
public class NaverRestController {
    private static final APILogger logger = new APILogger(NaverRestController.class);

    private final NaverService service;

    public NaverRestController(NaverService service) {
        this.service = service;
    }

    @PostMapping()
    @ApiOperation(value = "get Naver Authorization", notes = ".")
    public Object generateSignature(
            @Valid @RequestBody NaverDto.Request request) {
        Object response = service.generateSignature(request);
        logger.logApi(RequestMethod.POST, Constant.API_NAVER, request, response);
        return response;
    }
}
