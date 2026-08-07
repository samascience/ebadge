package com.tencent.open.b;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    protected static e a;

    protected e() {
    }

    public static synchronized e a() {
        try {
            if (a == null) {
                a = new e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        h.a().a(l.a(str, str3, str4, str5, str2, str6), str2, true);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        h.a().a(l.a(str, str4, str5, str3, str2, str6, Constants.STR_EMPTY, str7, str8, Constants.STR_EMPTY, Constants.STR_EMPTY, Constants.STR_EMPTY), str2, false);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        h.a().a(l.a(str, str4, str5, str3, str2, str6, str7, Constants.STR_EMPTY, Constants.STR_EMPTY, str8, str9, str10), str2, false);
    }

    public void a(int i, String str, String str2, String str3, String str4, Long l, int i2, int i3, String str5) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
        if (l.longValue() == 0 || jElapsedRealtime < 0) {
            jElapsedRealtime = 0;
        }
        StringBuffer stringBuffer = new StringBuffer("https://huatuocode.huatuo.qq.com");
        stringBuffer.append("?domain=mobile.opensdk.com&cgi=opensdk&type=");
        stringBuffer.append(i);
        stringBuffer.append("&code=");
        stringBuffer.append(i2);
        stringBuffer.append("&time=");
        stringBuffer.append(jElapsedRealtime);
        stringBuffer.append("&rate=");
        stringBuffer.append(i3);
        stringBuffer.append("&uin=");
        stringBuffer.append(str2);
        try {
            String strEncode = URLEncoder.encode(HttpUtils.encodeUrl(a(String.valueOf(i), String.valueOf(i2), String.valueOf(jElapsedRealtime), String.valueOf(i3), str, str2, str3, str4, str5)), Constants.ENC_UTF_8);
            stringBuffer.append("&data");
            stringBuffer.append("=");
            stringBuffer.append(strEncode);
            h.a().a(stringBuffer.toString(), (Map<String, String>) null);
        } catch (UnsupportedEncodingException e) {
            SLog.e("openSDK_LOG.OpenSdkStatic", "reportHaboCgi exception.", e);
        }
    }

    public static Map<String, String> a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        HashMap map = new HashMap();
        map.put(Constants.PARAM_PLATFORM, "1");
        map.put("result", str);
        map.put("code", str2);
        map.put("tmcost", str3);
        map.put("rate", str4);
        map.put("cmd", str5);
        map.put("uin", str6);
        map.put("appid", str7);
        map.put("share_type", str8);
        map.put("detail", str9);
        map.put("os_ver", Build.VERSION.RELEASE);
        map.put("network", a.a(com.tencent.open.utils.g.a()));
        map.put("apn", a.b(com.tencent.open.utils.g.a()));
        map.put(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().b(com.tencent.open.utils.g.a()));
        map.put(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
        map.put("packagename", com.tencent.open.utils.g.b());
        map.put(Constants.PARAM_APP_VER, l.d(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
        return map;
    }
}
