package defpackage;

import com.alibaba.dashscope.protocol.Protocol;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class t50 {
    public static Map a(String str, Boolean bool, Protocol protocol, Boolean bool2, Boolean bool3, String str2, Map map) {
        return b(str, bool, protocol, bool2, bool3, str2, map, null);
    }

    public static Map b(String str, Boolean bool, Protocol protocol, Boolean bool2, Boolean bool3, String str2, Map map, String str3) {
        HashMap map2 = new HashMap();
        map2.put("Authorization", "Bearer " + f8.a(str));
        map2.put("user-agent", e(str3));
        if (bool.booleanValue()) {
            map2.put("X-DashScope-DataInspection", "enable");
        }
        if (str2 != null && !str2.isEmpty()) {
            map2.put("X-DashScope-WorkSpace", str2);
        }
        if (protocol == Protocol.HTTP) {
            if (bool3.booleanValue()) {
                map2.put("X-DashScope-Async", "enable");
            }
            map2.put("Content-Type", "application/json");
            if (bool2.booleanValue()) {
                map2.put("Cache-Control", "no-cache");
                map2.put("Accept", "text/event-stream");
                map2.put("X-Accel-Buffering", "no");
                map2.put("X-DashScope-SSE", "enable");
            } else {
                map2.put("Accept", "application/json; charset=utf-8");
            }
        }
        if (!map.isEmpty()) {
            map2.putAll(map);
        }
        return map2;
    }

    public static Map c(String str, boolean z, String str2, Map map, String str3) {
        HashMap map2 = new HashMap();
        map2.put("Authorization", "Bearer " + f8.a(str));
        map2.put("user-agent", e(str3));
        if (str2 != null && !str2.isEmpty()) {
            map2.put("X-DashScope-WorkSpace", str2);
        }
        if (z) {
            map2.put("X-DashScope-DataInspection", "enable");
        }
        if (!map.isEmpty()) {
            map2.putAll(map);
        }
        return map2;
    }

    public static String d() {
        return e(null);
    }

    public static String e(String str) {
        String strA = uv2.a("dashscope/%s; java/%s; platform/%s; processor/%s", "2.17.0", System.getProperty("java.version"), System.getProperty("os.name"), System.getProperty("os.arch"));
        if (str == null || str.isEmpty()) {
            return strA;
        }
        return strA + "; " + str;
    }
}
