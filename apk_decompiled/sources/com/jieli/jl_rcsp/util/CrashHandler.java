package com.jieli.jl_rcsp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import com.tencent.connect.common.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final String TAG = "CrashHandler";

    @SuppressLint({"StaticFieldLeak"})
    public static volatile CrashHandler e;
    public Thread.UncaughtExceptionHandler a;
    public Context b;
    public final Map<String, String> c = new HashMap();
    public OnExceptionListener d;

    public interface OnExceptionListener {
        void onException(Throwable th);
    }

    public static CrashHandler getInstance() {
        if (e == null) {
            synchronized (CrashHandler.class) {
                try {
                    if (e == null) {
                        e = new CrashHandler();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    public final boolean a(Throwable th) {
        if (th == null) {
            return false;
        }
        OnExceptionListener onExceptionListener = this.d;
        if (onExceptionListener != null) {
            onExceptionListener.onException(th);
        }
        a(this.b);
        b(th);
        return true;
    }

    public final String b(Throwable th) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        sb.append(stringWriter.toString());
        JL_Log.e(TAG, "saveCrashInfo2File", sb.toString());
        return null;
    }

    public void init(Context context) {
        this.b = context;
        if (this.a == null) {
            this.a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void setOnExceptionListener(OnExceptionListener onExceptionListener) {
        this.d = onExceptionListener;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (thread == null || th == null) {
            return;
        }
        if (!a(th) && (uncaughtExceptionHandler = this.a) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e2) {
            JL_Log.e(TAG, "uncaughtException", "InterruptedException error : " + a((Exception) e2));
        }
        this.a = null;
        this.b = null;
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    public final void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                if (str == null) {
                    str = "null";
                }
                String str2 = packageInfo.versionCode + Constants.STR_EMPTY;
                this.c.put("versionName", str);
                this.c.put("versionCode", str2);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            JL_Log.e(TAG, "collectDeviceInfo", "an error occured when collect package info : " + a((Exception) e2));
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.get(null) != null) {
                    this.c.put(field.getName(), field.get(null).toString());
                    JL_Log.d(TAG, field.getName(), Constants.STR_EMPTY + field.get(null));
                }
            } catch (Exception e3) {
                JL_Log.e(TAG, "collectDeviceInfo", "an error occured when collect crash info : " + a(e3));
            }
        }
    }

    public final String a(Exception exc) {
        if (exc == null) {
            return null;
        }
        return exc.toString();
    }
}
