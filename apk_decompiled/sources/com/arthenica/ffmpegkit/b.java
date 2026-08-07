package com.arthenica.ffmpegkit;

import defpackage.ad1;
import defpackage.wt2;
import defpackage.yj0;
import defpackage.zj0;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static void a() {
        FFmpegKitConfig.nativeFFmpegCancel(0L);
    }

    public static yj0 b(String str) {
        return e(FFmpegKitConfig.m(str));
    }

    public static yj0 c(String str, zj0 zj0Var) {
        return f(FFmpegKitConfig.m(str), zj0Var);
    }

    public static yj0 d(String str, zj0 zj0Var, ad1 ad1Var, wt2 wt2Var) {
        return g(FFmpegKitConfig.m(str), zj0Var, ad1Var, wt2Var);
    }

    public static yj0 e(String[] strArr) {
        yj0 yj0VarU = yj0.u(strArr);
        FFmpegKitConfig.f(yj0VarU);
        return yj0VarU;
    }

    public static yj0 f(String[] strArr, zj0 zj0Var) {
        yj0 yj0VarV = yj0.v(strArr, zj0Var);
        FFmpegKitConfig.d(yj0VarV);
        return yj0VarV;
    }

    public static yj0 g(String[] strArr, zj0 zj0Var, ad1 ad1Var, wt2 wt2Var) {
        yj0 yj0VarW = yj0.w(strArr, zj0Var, ad1Var, wt2Var);
        FFmpegKitConfig.d(yj0VarW);
        return yj0VarW;
    }
}
