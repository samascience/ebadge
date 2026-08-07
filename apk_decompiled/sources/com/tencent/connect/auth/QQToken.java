package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;
    private static SharedPreferences g;
    private String a;
    private String b;
    private String c;
    private int d = 1;
    private long e = -1;
    private com.tencent.open.utils.a f;

    public QQToken(String str) {
        this.a = str;
    }

    @TargetApi(11)
    private static synchronized SharedPreferences a() {
        try {
            if (g == null) {
                g = g.a().getSharedPreferences("token_info_file", 0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    @Deprecated
    private static String b(String str) {
        return Base64.encodeToString(l.j(str), 2);
    }

    @Deprecated
    private static String c(String str) {
        return Base64.encodeToString(l.j(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.b;
    }

    public String getAppId() {
        return this.a;
    }

    public int getAuthSource() {
        return this.d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public String getOpenId() {
        return this.c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (TextUtils.isEmpty(openId)) {
                JSONObject jSONObjectLoadSession = loadSession(this.a);
                if (jSONObjectLoadSession != null) {
                    openId = jSONObjectLoadSession.getString("openid");
                    if (!TextUtils.isEmpty(openId)) {
                        setOpenId(openId);
                    }
                }
                SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.a);
            } else {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.a);
            }
        } catch (Exception e) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e.toString());
        }
        return openId;
    }

    public boolean isSessionValid() {
        return this.b != null && System.currentTimeMillis() < this.e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(g.a());
            }
            return a(str, this.f);
        } catch (Exception e) {
            SLog.i("QQToken", "login loadSession" + e.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor editorEdit = a().edit();
        editorEdit.remove(c(str));
        editorEdit.remove(c(str));
        editorEdit.remove(a(str));
        editorEdit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f == null) {
                this.f = new com.tencent.open.utils.a(g.a());
            }
            return a(this.a, jSONObject, this.f);
        } catch (Exception e) {
            SLog.i("QQToken", "login saveSession" + e.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.b = str;
        this.e = 0L;
        if (str2 != null) {
            this.e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.a = str;
    }

    public void setAuthSource(int i) {
        this.d = i;
    }

    public void setOpenId(String str) {
        this.c = str;
        com.tencent.open.b.b.a().a(str);
    }

    private static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        String strB;
        if (g.a() == null) {
            SLog.i("QQToken", "loadJsonPreference context null");
            return null;
        }
        if (str == null) {
            SLog.i("QQToken", "loadJsonPreference prefKey is null");
            return null;
        }
        String string = a().getString(a(str), Constants.STR_EMPTY);
        if (TextUtils.isEmpty(string)) {
            if (!JniInterface.isJniOk) {
                j.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                JniInterface.loadSo();
            }
            if (!JniInterface.isJniOk) {
                SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                return null;
            }
            String strC = c(str);
            String string2 = a().getString(strC, Constants.STR_EMPTY);
            try {
                if (TextUtils.isEmpty(string2)) {
                    String strB2 = b(str);
                    String string3 = a().getString(strB2, Constants.STR_EMPTY);
                    try {
                        if (TextUtils.isEmpty(string3)) {
                            SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                            return null;
                        }
                        try {
                            strB = JniInterface.d1(string3);
                            if (TextUtils.isEmpty(strB)) {
                                SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                a().edit().remove(strB2).apply();
                                return null;
                            }
                            a(str, new JSONObject(strB), aVar);
                            a().edit().remove(strB2).apply();
                        } catch (Exception e) {
                            SLog.e("QQToken", "Catch Exception", e);
                            a().edit().remove(strB2).apply();
                            return null;
                        }
                    } catch (Throwable th) {
                        a().edit().remove(strB2).apply();
                        throw th;
                    }
                } else {
                    try {
                        strB = JniInterface.d2(string2);
                        a(str, new JSONObject(strB), aVar);
                        a().edit().remove(strC).apply();
                    } catch (Exception e2) {
                        SLog.e("QQToken", "Catch Exception", e2);
                        a().edit().remove(strC).apply();
                        return null;
                    }
                }
            } catch (Throwable th2) {
                a().edit().remove(strC).apply();
                throw th2;
            }
            throw th;
        }
        strB = aVar.b(string);
        try {
            JSONObject jSONObject = new JSONObject(strB);
            SLog.i("QQToken", "loadJsonPreference sucess");
            return jSONObject;
        } catch (Exception e3) {
            SLog.i("QQToken", "loadJsonPreference decode " + e3.toString());
            return null;
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        if (g.a() == null) {
            SLog.i("QQToken", "saveJsonPreference context null");
            return false;
        }
        if (str != null && jSONObject != null) {
            try {
                String string = jSONObject.getString(Constants.PARAM_EXPIRES_IN);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(Constants.PARAM_EXPIRES_TIME, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                    String strA = a(str);
                    String strA2 = aVar.a(jSONObject.toString());
                    if (strA.length() > 6 && strA2 != null) {
                        a().edit().putString(strA, strA2).commit();
                        SLog.i("QQToken", "saveJsonPreference sucess");
                        return true;
                    }
                    SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                    return false;
                }
                SLog.i("QQToken", "expires is null");
                return false;
            } catch (Exception e) {
                SLog.e("QQToken", "saveJsonPreference exception:" + e.toString());
                return false;
            }
        }
        SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
        return false;
    }

    private static String a(String str) {
        return Base64.encodeToString(l.j(str), 2) + "_aes_google";
    }
}
