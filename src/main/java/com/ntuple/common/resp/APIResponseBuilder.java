package com.ntuple.common.resp;

import com.ntuple.common.enums.ResultMessages;
import org.springframework.stereotype.Component;

@Component
public class APIResponseBuilder {


    public static APIResponse buildResponse(ResultMessages resultMsg) {
        return new APIResponse(resultMsg.getCode(), resultMsg.getMessageCode(),
                resultMsg.getMessageCode(), null);
    }

    public static APIResponse buildResponse(ResultMessages resultMsg, Object data) {
        return new APIResponse(resultMsg.getCode(), resultMsg.getMessageCode(),
                resultMsg.getMessageCode(), data);
    }

    public static APIResponse buildResponse(ResultMessages resultMsg, String customMsg, Object data) {
        return new APIResponse(resultMsg.getCode(), resultMsg.getMessageCode(), customMsg, data);
    }
}
