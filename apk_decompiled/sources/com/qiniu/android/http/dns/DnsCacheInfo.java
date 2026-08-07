package com.qiniu.android.http.dns;

import defpackage.ey0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DnsCacheInfo implements Serializable {
    private String currentTime;
    private ConcurrentHashMap<String, List<ey0>> info;
    private String localIp;

    public DnsCacheInfo() {
    }

    public static DnsCacheInfo createDnsCacheInfoByData(byte[] bArr) {
        String string;
        String string2;
        JSONObject jSONObject;
        if (bArr == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(new String(bArr));
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            try {
                string = jSONObject2.getString("currentTime");
            } catch (Exception unused) {
                string = null;
            }
            try {
                string2 = jSONObject2.getString("localIp");
            } catch (Exception unused2) {
                string2 = null;
            }
            try {
                jSONObject = jSONObject2.getJSONObject("info");
            } catch (Exception unused3) {
                jSONObject = null;
            }
            if (string == null || string2 == null || jSONObject == null) {
                return null;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(DnsNetworkAddress.address(jSONArray.getJSONObject(i)));
                    }
                    if (arrayList.size() > 0) {
                        concurrentHashMap.put(next, arrayList);
                    }
                } catch (Exception unused4) {
                }
            }
            return new DnsCacheInfo(string, string2, concurrentHashMap);
        } catch (Exception unused5) {
            return null;
        }
    }

    public String cacheKey() {
        return this.localIp;
    }

    String getCurrentTime() {
        return this.currentTime;
    }

    public ConcurrentHashMap<String, List<ey0>> getInfo() {
        return this.info;
    }

    String getLocalIp() {
        return this.localIp;
    }

    void setCurrentTime(String str) {
        this.currentTime = str;
    }

    public void setInfo(ConcurrentHashMap<String, List<ey0>> concurrentHashMap) {
        this.info = concurrentHashMap;
    }

    void setLocalIp(String str) {
        this.localIp = str;
    }

    public byte[] toJsonData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("currentTime", this.currentTime);
        } catch (JSONException unused) {
        }
        try {
            jSONObject.putOpt("localIp", this.localIp);
        } catch (JSONException unused2) {
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.info.keySet()) {
            List<ey0> list = this.info.get(str);
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                for (ey0 ey0Var : list) {
                    if (ey0Var instanceof DnsNetworkAddress) {
                        try {
                            jSONArray.put(((DnsNetworkAddress) ey0Var).toJson());
                        } catch (Exception unused3) {
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                try {
                    jSONObject2.put(str, jSONArray);
                } catch (JSONException unused4) {
                }
            }
        }
        try {
            jSONObject.putOpt("info", jSONObject2);
        } catch (JSONException unused5) {
        }
        return jSONObject.toString().getBytes();
    }

    public String toString() {
        return "{\"currentTime\":\"" + this.currentTime + "\", \"localIp\":\"" + this.localIp + "\"}";
    }

    public DnsCacheInfo(String str, String str2, ConcurrentHashMap<String, List<ey0>> concurrentHashMap) {
        this.currentTime = str;
        this.localIp = str2;
        this.info = concurrentHashMap;
    }
}
