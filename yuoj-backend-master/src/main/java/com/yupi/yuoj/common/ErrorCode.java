package com.yupi.yuoj.common;

/**
 * Custom Error Codes
 *
 */
public enum ErrorCode {

    SUCCESS(0, "ok"),
    PARAMS_ERROR(40000, "Request parameter error"),
    NOT_LOGIN_ERROR(40100, "not logged in"),
    NO_AUTH_ERROR(40101, "no entitlement"),
    NOT_FOUND_ERROR(40400, "Requested data does not exist"),
    FORBIDDEN_ERROR(40300, "forbid sb. to visit"),
    SYSTEM_ERROR(50000, "Internal system anomalies"),
    OPERATION_ERROR(50001, "failure of an operation"),
    API_REQUEST_ERROR(50010, "Interface Call Failure");

    /**
     * status code
     */
    private final int code;

    /**
     * information
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
