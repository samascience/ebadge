package com.tencent.connect.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private AuthAgent a;
    private QQToken b;

    private c(String str, Context context) {
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.b = new QQToken(str);
        this.a = new AuthAgent(this.b);
        com.tencent.connect.a.a.c(context, this.b);
        a(context, Constants.SDK_VERSION);
        SLog.i("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
        editorEdit.putString("bcb3903995", str);
        editorEdit.apply();
    }

    public int b(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQAuth", "reAuth()");
        return this.a.a(activity, str, iUiListener, true, null, false);
    }

    public boolean c() {
        StringBuilder sb = new StringBuilder();
        sb.append("isSessionValid(), result = ");
        sb.append(this.b.isSessionValid() ? "true" : "false");
        SLog.i("openSDK_LOG.QQAuth", sb.toString());
        return this.b.isSessionValid();
    }

    public QQToken b() {
        return this.b;
    }

    public void b(Context context, String str) {
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.b.setOpenId(str);
        com.tencent.connect.a.a.d(context, this.b);
        SLog.i("openSDK_LOG.QQAuth", "setOpenId() --end");
    }

    public static c a(String str, Context context) {
        g.a(context.getApplicationContext());
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        c cVar = new c(str, context);
        SLog.i("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
        return cVar;
    }

    public int a(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, str, iUiListener, Constants.STR_EMPTY);
    }

    public int a(Activity activity, String str, IUiListener iUiListener, boolean z) {
        SLog.i("openSDK_LOG.QQAuth", "login()");
        return a(activity, null, str, iUiListener, Constants.STR_EMPTY, z);
    }

    public int a(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.i("openSDK_LOG.QQAuth", "login--params");
        return a(activity, (Fragment) null, l.a(map, Constants.KEY_SCOPE, "all"), iUiListener, Constants.STR_EMPTY, l.a(map, Constants.KEY_QRCODE, false), map);
    }

    public int a(Activity activity, String str, IUiListener iUiListener, String str2) {
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, (Fragment) null, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        FragmentActivity activity = fragment.getActivity();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        FragmentActivity activity = fragment.getActivity();
        SLog.i("openSDK_LOG.QQAuth", "-->login activity: " + activity);
        return a(activity, fragment, str, iUiListener, str2, z);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        return a(activity, fragment, str, iUiListener, str2, false);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z) {
        return a(activity, fragment, str, iUiListener, str2, z, (Map<String, Object>) null);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2, boolean z, Map<String, Object> map) {
        try {
            String strA = j.a(activity);
            if (strA != null) {
                String strA2 = com.tencent.open.utils.b.a(new File(strA));
                if (!TextUtils.isEmpty(strA2)) {
                    SLog.v("openSDK_LOG.QQAuth", "-->login channelId: " + strA2);
                    return a(activity, str, iUiListener, z, strA2, strA2, Constants.STR_EMPTY);
                }
            }
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.QQAuth", "-->login get channel id exception.", th);
        }
        SLog.d("openSDK_LOG.QQAuth", "-->login channelId is null ");
        BaseApi.isOEM = false;
        return this.a.doLogin(activity, str, iUiListener, false, fragment, z, map);
    }

    @Deprecated
    public int a(Activity activity, String str, IUiListener iUiListener, boolean z, String str2, String str3, String str4) {
        SLog.i("openSDK_LOG.QQAuth", "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals(Constants.STR_EMPTY)) {
            str2 = "null";
        }
        if (str3.equals(Constants.STR_EMPTY)) {
            str3 = "null";
        }
        if (str4.equals(Constants.STR_EMPTY)) {
            str4 = "null";
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.a.a(activity, str, iUiListener, false, null, z);
    }

    public void a() {
        this.a.a((IUiListener) null);
    }

    public void a(IUiListener iUiListener) {
        this.a.b(iUiListener);
    }

    public void a(String str, String str2) {
        SLog.i("openSDK_LOG.QQAuth", "setAccessToken(), validTimeInSecond = " + str2 + Constants.STR_EMPTY);
        this.b.setAccessToken(str, str2);
    }
}
