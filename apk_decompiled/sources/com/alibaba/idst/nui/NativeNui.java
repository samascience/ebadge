package com.alibaba.idst.nui;

import android.util.Log;
import defpackage.l00;
import defpackage.ny0;

/* JADX INFO: loaded from: classes.dex */
public class NativeNui implements AutoCloseable {
    private static boolean h = false;
    private long c;
    private boolean a = false;
    private Constants$ModeType b = Constants$ModeType.MODE_DIALOG;
    private long d = 0;
    private ny0 e = null;
    private long f = 0;
    private long g = 0;

    static {
        Log.i("NativeNui_JAVA", "load library neonui");
        try {
            System.loadLibrary("neonuijni_public");
            h = true;
            Log.i("NativeNui_JAVA", "load library succeeded");
        } catch (Throwable th) {
            h = false;
            Log.e("NativeNui_JAVA", "load library failed, " + th);
        }
        Log.i("NativeNui_JAVA", "load library done");
    }

    public NativeNui() {
        this.c = 0L;
        if (!h) {
            Log.e("NativeNui_JAVA", "library is not loaded");
            return;
        }
        this.c = native_get_new_nui();
        Log.i("NativeNui_JAVA", "nui handle = " + this.c);
    }

    private synchronized void n() {
        if (this.c == 0) {
            this.c = native_get_new_nui();
            Log.i("NativeNui_JAVA", "check and new nui " + this.c);
        }
    }

    private native int native_cancel_dialog(long j, boolean z);

    private native long native_get_new_nui();

    private native int native_init(long j, String str, int i, boolean z);

    private native int native_release(long j);

    private native int native_set_params(long j, String str);

    private native int native_start_dialog(long j, int i, String str);

    private native int native_stream_input_tts_release(long j);

    private native int native_tts_release(long j);

    private native int native_utils_release(long j);

    public synchronized int C(Constants$VadMode constants$VadMode, String str) {
        if (!h) {
            Log.e("NativeNui_JAVA", "library is not loaded");
            return 999999;
        }
        n();
        return native_start_dialog(this.c, constants$VadMode.getCode(), str);
    }

    public synchronized int D() {
        if (!h) {
            Log.e("NativeNui_JAVA", "library is not loaded");
            return 999999;
        }
        n();
        return native_cancel_dialog(this.c, false);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Log.i("NativeNui_JAVA", "close ....");
        w();
    }

    protected void finalize() {
        w();
    }

    public synchronized int u(ny0 ny0Var, String str, Constants$LogLevel constants$LogLevel, boolean z) {
        if (!h) {
            Log.e("NativeNui_JAVA", "library is not loaded");
            return 999999;
        }
        this.e = ny0Var;
        n();
        return native_init(this.c, l00.a(str), Constants$LogLevel.toInt(constants$LogLevel), z);
    }

    public synchronized int w() {
        if (!h) {
            Log.e("NativeNui_JAVA", "library is not loaded");
            return 999999;
        }
        if (this.c != 0) {
            Log.i("NativeNui_JAVA", "release NUI ->");
            native_release(this.c);
            this.c = 0L;
            this.e = null;
        }
        if (this.d != 0) {
            Log.i("NativeNui_JAVA", "release NUI utils ->");
            native_utils_release(this.d);
            this.d = 0L;
        }
        if (this.f != 0) {
            Log.i("NativeNui_JAVA", "release NUI TTS ->");
            native_tts_release(this.f);
            this.f = 0L;
        }
        if (this.g != 0) {
            Log.i("NativeNui_JAVA", "release NUI StreamInputTTs ->");
            native_stream_input_tts_release(this.g);
            this.g = 0L;
        }
        return 0;
    }

    public synchronized int y(String str) {
        if (!h) {
            Log.e("NativeNui_JAVA", "library is not loaded");
            return 999999;
        }
        Log.i("NativeNui_JAVA", "set param with " + str);
        n();
        return native_set_params(this.c, str);
    }
}
