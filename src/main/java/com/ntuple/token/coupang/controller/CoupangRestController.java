package com.ntuple.token.coupang.controller;

import com.ntuple.common.APILogger;
import com.ntuple.common.Constant;
import com.ntuple.token.coupang.model.CoupangDto;
import com.ntuple.token.coupang.service.CoupangService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = Constant.API_COUPANG)
public class CoupangRestController {
    private static final APILogger logger = new APILogger(CoupangRestController.class);

    private final CoupangService service;

    public CoupangRestController(CoupangService service) {
        this.service = service;
    }

    @PostMapping()
    @ApiOperation(value = "get Coupang Authorization", notes = "generate Signature")
    public Object generateSignature(
            @Valid @RequestBody CoupangDto.Request request) throws URISyntaxException {
        Object response = service.getAuthorization(request);
        logger.logApi(RequestMethod.POST, Constant.API_COUPANG, request, response);
        return response;
    }
}
