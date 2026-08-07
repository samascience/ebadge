package com.tenmeter.smlibrary.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class SMGameSecretValid implements Serializable {
    private String baseUrl;
    private String env;

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getEnv() {
        return this.env;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setEnv(String str) {
        this.env = str;
    }
}
