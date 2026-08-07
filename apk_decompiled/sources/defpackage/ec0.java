package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ec0 implements yb0 {
    private final File b;
    private final long c;
    private cc0 e;
    private final bc0 d = new bc0();
    private final mj2 a = new mj2();

    protected ec0(File file, long j) {
        this.b = file;
        this.c = j;
    }

    public static yb0 c(File file, long j) {
        return new ec0(file, j);
    }

    private synchronized cc0 d() {
        try {
            if (this.e == null) {
                this.e = cc0.G0(this.b, 1, 1, this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e;
    }

    @Override // defpackage.yb0
    public File a(w81 w81Var) {
        String strB = this.a.b(w81Var);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + w81Var);
        }
        try {
            cc0.e eVarA0 = d().A0(strB);
            if (eVarA0 != null) {
                return eVarA0.a(0);
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    @Override // defpackage.yb0
    public void b(w81 w81Var, yb0.b bVar) {
        String strB = this.a.b(w81Var);
        this.d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + w81Var);
            }
            try {
                cc0 cc0VarD = d();
                if (cc0VarD.A0(strB) != null) {
                    this.d.b(strB);
                    return;
                }
                cc0.c cVarT0 = cc0VarD.t0(strB);
                if (cVarT0 == null) {
                    throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                }
                try {
                    if (bVar.a(cVarT0.f(0))) {
                        cVarT0.e();
                    }
                    cVarT0.b();
                    this.d.b(strB);
                } catch (Throwable th) {
                    cVarT0.b();
                    throw th;
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
        } catch (Throwable th2) {
            this.d.b(strB);
            throw th2;
        }
    }
}
