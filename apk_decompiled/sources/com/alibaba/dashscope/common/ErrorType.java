package com.alibaba.dashscope.common;

/* JADX INFO: loaded from: classes.dex */
public enum ErrorType {
    RESPONSE_ERROR("response_error"),
    REQUEST_CANCELLED("request_cancelled"),
    PROTOCOL_UNSUPPORTED("protocol_unsupported"),
    API_KEY_ERROR("api_key_error"),
    UNKNOWN_ERROR("unknown_error"),
    NETWORK_ERROR("network error");

    private final String value;

    ErrorType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
