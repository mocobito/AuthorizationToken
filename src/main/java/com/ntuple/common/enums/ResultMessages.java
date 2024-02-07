/**
 *
 */
package com.ntuple.common.enums;

public enum ResultMessages {

    // @formatter:off
		API_SUCCESS("00", "api.success");
    // @formatter:on

    private String code;
    private String messageCode;

    public String getCode() {
        return code;
    }

    public String getMessageCode() {
        return messageCode;
    }

    ResultMessages(String code, String messageCode) {
        this.code = code;
        this.messageCode = messageCode;
    }
}
