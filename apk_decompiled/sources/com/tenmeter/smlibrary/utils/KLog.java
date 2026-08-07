package com.tenmeter.smlibrary.utils;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class KLog {
    private static final int A = 6;
    private static final int D = 2;
    private static final String DEFAULT_MESSAGE = "execute";
    private static final int E = 5;
    private static final int I = 3;
    private static final int JSON = 7;
    private static final int JSON_INDENT = 4;
    private static final int V = 1;
    private static final int W = 4;
    private static boolean IS_SHOW_LOG = SMGameClient.isDev;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void a() {
        printLog(6, null, DEFAULT_MESSAGE);
    }

    public static void d() {
        printLog(2, null, DEFAULT_MESSAGE);
    }

    public static void e() {
        printLog(5, null, DEFAULT_MESSAGE);
    }

    public static void i() {
        printLog(3, null, DEFAULT_MESSAGE);
    }

    public static void init(boolean z) {
        IS_SHOW_LOG = z;
    }

    public static void json(String str) {
        printLog(7, null, str);
    }

    private static void printLine(String str, boolean z) {
        if (z) {
            Log.w(str, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.w(str, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }

    private static void printLog(int i, String str, Object obj) {
        if (SMGameClient.isDev) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String fileName = stackTrace[4].getFileName();
            String methodName = stackTrace[4].getMethodName();
            int lineNumber = stackTrace[4].getLineNumber();
            if (str == null) {
                str = fileName;
            }
            String str2 = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
            StringBuilder sb = new StringBuilder();
            sb.append("[ (");
            sb.append(fileName);
            sb.append(":");
            sb.append(lineNumber);
            sb.append(")#");
            sb.append(str2);
            sb.append(" ] ");
            String string = obj == null ? "Log with null Object" : obj.toString();
            if (string != null && i != 7) {
                sb.append(string);
            }
            String string2 = sb.toString();
            switch (i) {
                case 1:
                    Log.v(str, string2);
                    break;
                case 2:
                    Log.d(str, string2);
                    break;
                case 3:
                    Log.i(str, string2);
                    break;
                case 4:
                    Log.w(str, string2);
                    break;
                case 5:
                    Log.e(str, string2);
                    break;
                case 6:
                    Log.wtf(str, string2);
                    break;
                case 7:
                    if (TextUtils.isEmpty(string)) {
                        Log.d(str, "Empty or Null json content");
                    } else {
                        try {
                            String string3 = string.startsWith("{") ? new JSONObject(string).toString(4) : string.startsWith("[") ? new JSONArray(string).toString(4) : null;
                            printLine(str, true);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(string2);
                            String str3 = LINE_SEPARATOR;
                            sb2.append(str3);
                            sb2.append(string3);
                            String[] strArrSplit = sb2.toString().split(str3);
                            StringBuilder sb3 = new StringBuilder();
                            for (String str4 : strArrSplit) {
                                sb3.append("║ ");
                                sb3.append(str4);
                                sb3.append(LINE_SEPARATOR);
                            }
                            if (sb3.toString().length() > 3200) {
                                Log.w(str, "jsonContent.length = " + sb3.toString().length());
                                int length = sb3.toString().length() / 3200;
                                int i2 = 0;
                                while (i2 <= length) {
                                    int i3 = i2 + 1;
                                    int i4 = i3 * 3200;
                                    if (i4 >= sb3.toString().length()) {
                                        Log.w(str, sb3.toString().substring(i2 * 3200));
                                    } else {
                                        Log.w(str, sb3.toString().substring(i2 * 3200, i4));
                                    }
                                    i2 = i3;
                                }
                            } else {
                                Log.w(str, sb3.toString());
                            }
                            printLine(str, false);
                        } catch (JSONException e) {
                            e(str, e.getCause().getMessage() + "\n" + string);
                            return;
                        }
                    }
                    break;
            }
        }
    }

    public static void v() {
        printLog(1, null, DEFAULT_MESSAGE);
    }

    public static void w() {
        printLog(4, null, DEFAULT_MESSAGE);
    }

    public static void a(Object obj) {
        printLog(6, null, obj);
    }

    public static void d(Object obj) {
        printLog(2, null, obj);
    }

    public static void e(Object obj) {
        printLog(5, null, obj);
    }

    public static void i(Object obj) {
        printLog(3, null, obj);
    }

    public static void json(String str, String str2) {
        printLog(7, str, str2);
    }

    public static void v(Object obj) {
        printLog(1, null, obj);
    }

    public static void w(Object obj) {
        printLog(4, null, obj);
    }

    public static void a(String str, Object obj) {
        printLog(6, str, obj);
    }

    public static void d(String str, Object obj) {
        printLog(2, str, obj);
    }

    public static void e(String str, Object obj) {
        printLog(5, str, obj);
    }

    public static void i(String str, Object obj) {
        printLog(3, str, obj);
    }

    public static void v(String str, String str2) {
        printLog(1, str, str2);
    }

    public static void w(String str, Object obj) {
        printLog(4, str, obj);
    }
}
