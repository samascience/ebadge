package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import io.reactivex.annotations.SchedulerSupport;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    protected static final Uri a = Uri.parse("content://telephony/carriers/preferapn");

    public static String a(Context context) {
        int iD = d(context);
        if (iD == 2) {
            return "wifi";
        }
        if (iD == 1) {
            return "cmwap";
        }
        if (iD == 4) {
            return "cmnet";
        }
        if (iD == 16) {
            return "uniwap";
        }
        if (iD == 8) {
            return "uninet";
        }
        if (iD == 64) {
            return "wap";
        }
        if (iD == 32) {
            return "net";
        }
        if (iD == 512) {
            return "ctwap";
        }
        if (iD == 256) {
            return "ctnet";
        }
        if (iD == 2048) {
            return "3gnet";
        }
        if (iD == 1024) {
            return "3gwap";
        }
        String strB = b(context);
        return (strB == null || strB.length() == 0) ? SchedulerSupport.NONE : strB;
    }

    public static String b(Context context) {
        return Constants.STR_EMPTY;
    }

    public static String c(Context context) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(a, null, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.moveToFirst();
            if (cursorQuery.isAfterLast()) {
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("proxy"));
            cursorQuery.close();
            return string;
        } catch (SecurityException e) {
            SLog.e("openSDK_LOG.APNUtil", "getApnProxy has exception: " + e.getMessage());
            return Constants.STR_EMPTY;
        }
    }

    public static int d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 128;
            }
            if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
                return 2;
            }
            String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            if (lowerCase.startsWith("cmwap")) {
                return 1;
            }
            if (!lowerCase.startsWith("cmnet") && !lowerCase.startsWith("epc.tmobile.com")) {
                if (lowerCase.startsWith("uniwap")) {
                    return 16;
                }
                if (lowerCase.startsWith("uninet")) {
                    return 8;
                }
                if (lowerCase.startsWith("wap")) {
                    return 64;
                }
                if (lowerCase.startsWith("net")) {
                    return 32;
                }
                if (lowerCase.startsWith("ctwap")) {
                    return 512;
                }
                if (lowerCase.startsWith("ctnet")) {
                    return 256;
                }
                if (lowerCase.startsWith("3gwap")) {
                    return 1024;
                }
                if (lowerCase.startsWith("3gnet")) {
                    return 2048;
                }
                if (lowerCase.startsWith("#777")) {
                    String strC = c(context);
                    return (strC == null || strC.length() <= 0) ? 256 : 512;
                }
            }
            return 4;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.APNUtil", "getMProxyType has exception: " + e.getMessage());
        }
        return 128;
    }

    public static String e(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) ? "MOBILE" : activeNetworkInfo.getTypeName();
    }
}
