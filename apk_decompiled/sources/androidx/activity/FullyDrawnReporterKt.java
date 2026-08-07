package androidx.activity;

import defpackage.ar0;
import defpackage.j21;
import defpackage.k83;
import defpackage.wq0;
import defpackage.x30;
import kotlin.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class FullyDrawnReporterKt {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, k83] */
    public static final Object a(wq0 wq0Var, ar0 ar0Var, x30 x30Var) throws Throwable {
        FullyDrawnReporterKt$reportWhenComplete$1 fullyDrawnReporterKt$reportWhenComplete$1;
        wq0 wq0Var2;
        if (x30Var instanceof FullyDrawnReporterKt$reportWhenComplete$1) {
            fullyDrawnReporterKt$reportWhenComplete$1 = (FullyDrawnReporterKt$reportWhenComplete$1) x30Var;
            int i = fullyDrawnReporterKt$reportWhenComplete$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                fullyDrawnReporterKt$reportWhenComplete$1.label = i - Integer.MIN_VALUE;
            } else {
                fullyDrawnReporterKt$reportWhenComplete$1 = new FullyDrawnReporterKt$reportWhenComplete$1(x30Var);
            }
        } else {
            fullyDrawnReporterKt$reportWhenComplete$1 = new FullyDrawnReporterKt$reportWhenComplete$1(x30Var);
        }
        Object obj = fullyDrawnReporterKt$reportWhenComplete$1.result;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i2 = fullyDrawnReporterKt$reportWhenComplete$1.label;
        try {
            if (i2 == 0) {
                d.b(obj);
                wq0Var.b();
                if (wq0Var.d()) {
                    return k83.a;
                }
                fullyDrawnReporterKt$reportWhenComplete$1.L$0 = wq0Var;
                fullyDrawnReporterKt$reportWhenComplete$1.label = 1;
                if (ar0Var.invoke(fullyDrawnReporterKt$reportWhenComplete$1) == objD) {
                    wq0Var2 = wq0Var;
                    return objD;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                wq0 wq0Var3 = (wq0) fullyDrawnReporterKt$reportWhenComplete$1.L$0;
                d.b(obj);
                wq0Var2 = wq0Var3;
            }
            wq0Var2 = wq0Var;
            j21.b(1);
            wq0Var2.f();
            j21.a(1);
            wq0Var = k83.a;
            return wq0Var;
        } catch (Throwable th) {
            j21.b(1);
            wq0Var.f();
            j21.a(1);
            throw th;
        }
    }
}
