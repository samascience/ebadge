package com.iwellfitness.urllib;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public final class OpenUrlRequest {
    private final String title;
    private final String url;

    public OpenUrlRequest(String str) {
        this(str, null);
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public OpenUrlRequest(String str, String str2) {
        this.url = str == null ? Constants.STR_EMPTY : str;
        this.title = str2;
    }
}
