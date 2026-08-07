package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import defpackage.a52;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static e b;
    private final Context a;

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    public static e a(Context context) {
        a52.g(context);
        synchronized (e.class) {
            try {
                if (b == null) {
                    p.a(context);
                    b = new e(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    static final l c(PackageInfo packageInfo, l... lVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        m mVar = new m(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < lVarArr.length; i++) {
            if (lVarArr[i].equals(mVar)) {
                return lVarArr[i];
            }
        }
        return null;
    }

    public static final boolean d(PackageInfo packageInfo, boolean z) {
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & Opcodes.LOR) == 0) ? false : true;
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? c(packageInfo, o.a) : c(packageInfo, o.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (d(packageInfo, false)) {
            return true;
        }
        if (d(packageInfo, true)) {
            if (d.e(this.a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }
}
