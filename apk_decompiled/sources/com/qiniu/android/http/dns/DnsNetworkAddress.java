package com.qiniu.android.http.dns;

import defpackage.ey0;
import defpackage.tu0;
import defpackage.ua3;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class DnsNetworkAddress implements ey0, Serializable {
    private final String hostValue;
    private final String ipValue;
    private final String sourceValue;
    private final Long timestampValue;
    private final Long ttlValue;

    DnsNetworkAddress(String str, String str2, Long l, String str3, Long l2) {
        this.hostValue = str;
        this.ipValue = str2;
        this.ttlValue = l;
        this.sourceValue = str3;
        this.timestampValue = l2;
    }

    static DnsNetworkAddress address(JSONObject jSONObject) throws JSONException {
        String string;
        String string2;
        Long lValueOf;
        Long lValueOf2;
        String string3 = null;
        try {
            string = jSONObject.getString("hostValue");
        } catch (JSONException unused) {
            string = null;
        }
        try {
            string2 = jSONObject.getString("ipValue");
        } catch (JSONException unused2) {
            string2 = null;
        }
        try {
            lValueOf = Long.valueOf(jSONObject.getLong("ttlValue"));
        } catch (JSONException unused3) {
            lValueOf = null;
        }
        try {
            lValueOf2 = Long.valueOf(jSONObject.getLong("timestampValue"));
        } catch (JSONException unused4) {
            lValueOf2 = null;
        }
        try {
            string3 = jSONObject.getString("sourceValue");
        } catch (JSONException unused5) {
        }
        return new DnsNetworkAddress(string, string2, lValueOf, string3, lValueOf2);
    }

    public String getHostValue() {
        return this.hostValue;
    }

    public String getIpValue() {
        return this.ipValue;
    }

    public String getSourceValue() {
        return this.sourceValue;
    }

    public Long getTimestampValue() {
        return this.timestampValue;
    }

    public Long getTtlValue() {
        return this.ttlValue;
    }

    boolean isValid() {
        String str;
        if (this.timestampValue == null || (str = this.ipValue) == null || str.length() == 0) {
            return false;
        }
        return ua3.a() / 1000 < this.timestampValue.longValue() + ((long) tu0.a().e);
    }

    boolean needRefresh() {
        String str;
        if (this.timestampValue == null || this.ttlValue == null || (str = this.ipValue) == null || str.length() == 0) {
            return false;
        }
        return ua3.a() / 1000 > this.timestampValue.longValue() + ((long) this.ttlValue.intValue());
    }

    JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hostValue", this.hostValue);
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put("ipValue", this.ipValue);
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.put("ttlValue", this.ttlValue);
        } catch (JSONException unused3) {
        }
        try {
            jSONObject.put("timestampValue", this.timestampValue);
        } catch (JSONException unused4) {
        }
        try {
            jSONObject.put("sourceValue", this.sourceValue);
        } catch (JSONException unused5) {
        }
        return jSONObject;
    }
}
