package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import defpackage.ou3;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    private static int a = 4225;
    private static final Object b = new Object();
    private static a0 c = null;
    static HandlerThread d = null;
    private static boolean e = false;

    public static int a() {
        return a;
    }

    public static e b(Context context) {
        synchronized (b) {
            try {
                if (c == null) {
                    c = new a0(context.getApplicationContext(), e ? c().getLooper() : context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c;
    }

    public static HandlerThread c() {
        synchronized (b) {
            try {
                HandlerThread handlerThread = d;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                d = handlerThread2;
                handlerThread2.start();
                return d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected abstract void d(ou3 ou3Var, ServiceConnection serviceConnection, String str);

    public final void e(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        d(new ou3(str, str2, i, z), serviceConnection, str3);
    }

    protected abstract boolean f(ou3 ou3Var, ServiceConnection serviceConnection, String str, Executor executor);
}
