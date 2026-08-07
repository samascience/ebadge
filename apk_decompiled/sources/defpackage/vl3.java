package defpackage;

import com.jieli.jl_rcsp.constant.WatchConstant;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.collections.j;
import okio.internal.ZipFilesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class vl3 extends xm0 {
    private static final a i = new a(null);
    private static final hz1 j = hz1.a.e(hz1.b, WatchConstant.FAT_FS_ROOT, false, 1, null);
    private final hz1 e;
    private final xm0 f;
    private final Map g;
    private final String h;

    private static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public vl3(hz1 hz1Var, xm0 xm0Var, Map map, String str) {
        p31.f(hz1Var, "zipPath");
        p31.f(xm0Var, "fileSystem");
        p31.f(map, "entries");
        this.e = hz1Var;
        this.f = xm0Var;
        this.g = map;
        this.h = str;
    }

    private final hz1 f(hz1 hz1Var) {
        return j.k(hz1Var, true);
    }

    private final List g(hz1 hz1Var, boolean z) throws IOException {
        ul3 ul3Var = (ul3) this.g.get(f(hz1Var));
        if (ul3Var != null) {
            return j.X(ul3Var.b());
        }
        if (!z) {
            return null;
        }
        throw new IOException("not a directory: " + hz1Var);
    }

    @Override // defpackage.xm0
    public List a(hz1 hz1Var) throws IOException {
        p31.f(hz1Var, "dir");
        List listG = g(hz1Var, true);
        p31.c(listG);
        return listG;
    }

    @Override // defpackage.xm0
    public List b(hz1 hz1Var) {
        p31.f(hz1Var, "dir");
        return g(hz1Var, false);
    }

    @Override // defpackage.xm0
    public lm0 d(hz1 hz1Var) throws Throwable {
        lm0 lm0VarH;
        Throwable th;
        p31.f(hz1Var, "path");
        ul3 ul3Var = (ul3) this.g.get(f(hz1Var));
        Throwable th2 = null;
        if (ul3Var == null) {
            return null;
        }
        lm0 lm0Var = new lm0(!ul3Var.f(), ul3Var.f(), null, ul3Var.f() ? null : Long.valueOf(ul3Var.e()), null, ul3Var.c(), null, null, 128, null);
        if (ul3Var.d() == -1) {
            return lm0Var;
        }
        hm0 hm0VarE = this.f.e(this.e);
        try {
            so soVarB = hu1.b(hm0VarE.g0(ul3Var.d()));
            try {
                lm0VarH = ZipFilesKt.h(soVarB, lm0Var);
                if (soVarB != null) {
                    try {
                        soVarB.close();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                if (soVarB != null) {
                    try {
                        soVarB.close();
                    } catch (Throwable th5) {
                        oi0.a(th4, th5);
                    }
                }
                th = th4;
                lm0VarH = null;
            }
            if (th != null) {
                throw th;
            }
            p31.c(lm0VarH);
            if (hm0VarE != null) {
                try {
                    hm0VarE.close();
                } catch (Throwable th6) {
                    th2 = th6;
                }
            }
            if (th2 != null) {
                throw th2;
            }
            p31.c(lm0VarH);
            return lm0VarH;
        } catch (Throwable th7) {
            if (hm0VarE != null) {
                try {
                    hm0VarE.close();
                } catch (Throwable th8) {
                    oi0.a(th7, th8);
                }
            }
            lm0VarH = null;
            th2 = th7;
        }
    }

    @Override // defpackage.xm0
    public hm0 e(hz1 hz1Var) {
        p31.f(hz1Var, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }
}
