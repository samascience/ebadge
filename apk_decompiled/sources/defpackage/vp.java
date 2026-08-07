package defpackage;

import com.jieli.lib.gif.GifError;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import com.tencent.open.SocialConstants;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class vp {
    public static final a c = new a(null);
    private final df2 a;
    private final eh2 b;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:24:0x003b  */
        public final boolean a(eh2 eh2Var, df2 df2Var) {
            p31.f(eh2Var, "response");
            p31.f(df2Var, SocialConstants.TYPE_REQUEST);
            int iC = eh2Var.C();
            if (iC != 200 && iC != 410 && iC != 414 && iC != 501 && iC != 203 && iC != 204) {
                if (iC == 307) {
                    if (eh2.g0(eh2Var, "Expires", null, 2, null) == null && eh2Var.u().c() == -1 && !eh2Var.u().b() && !eh2Var.u().a()) {
                        return false;
                    }
                } else if (iC != 308 && iC != 404 && iC != 405) {
                    switch (iC) {
                        case ChartCoordinateportAnimator.FAST_ANIMATION_DURATION /* 300 */:
                        case GifError.ERR_INVALID_PARAM /* 301 */:
                            break;
                        case GifError.ERR_OP_IN_PROGRESS /* 302 */:
                            if (eh2.g0(eh2Var, "Expires", null, 2, null) == null) {
                                return false;
                            }
                            break;
                        default:
                            return false;
                    }
                }
            }
            return (eh2Var.u().h() || df2Var.b().h()) ? false : true;
        }

        private a() {
        }
    }

    public static final class b {
        private final long a;
        private final df2 b;
        private final eh2 c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public b(long j, df2 df2Var, eh2 eh2Var) {
            p31.f(df2Var, SocialConstants.TYPE_REQUEST);
            this.a = j;
            this.b = df2Var;
            this.c = eh2Var;
            this.l = -1;
            if (eh2Var != null) {
                this.i = eh2Var.H0();
                this.j = eh2Var.F0();
                iw0 iw0VarJ0 = eh2Var.j0();
                int size = iw0VarJ0.size();
                for (int i = 0; i < size; i++) {
                    String strB = iw0VarJ0.b(i);
                    String strG = iw0VarJ0.g(i);
                    if (i.v(strB, "Date", true)) {
                        this.d = b70.a(strG);
                        this.e = strG;
                    } else if (i.v(strB, "Expires", true)) {
                        this.h = b70.a(strG);
                    } else if (i.v(strB, "Last-Modified", true)) {
                        this.f = b70.a(strG);
                        this.g = strG;
                    } else if (i.v(strB, "ETag", true)) {
                        this.k = strG;
                    } else if (i.v(strB, "Age", true)) {
                        this.l = pa3.X(strG, -1);
                    }
                }
            }
        }

        private final long a() {
            Date date = this.d;
            long jMax = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return jMax + (j - this.i) + (this.a - j);
        }

        private final vp c() {
            String str;
            if (this.c == null) {
                return new vp(this.b, null);
            }
            if ((!this.b.f() || this.c.V() != null) && vp.c.a(this.c, this.b)) {
                tp tpVarB = this.b.b();
                if (tpVarB.g() || e(this.b)) {
                    return new vp(this.b, null);
                }
                tp tpVarU = this.c.u();
                long jA = a();
                long jD = d();
                if (tpVarB.c() != -1) {
                    jD = Math.min(jD, TimeUnit.SECONDS.toMillis(tpVarB.c()));
                }
                long millis = 0;
                long millis2 = tpVarB.e() != -1 ? TimeUnit.SECONDS.toMillis(tpVarB.e()) : 0L;
                if (!tpVarU.f() && tpVarB.d() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(tpVarB.d());
                }
                if (!tpVarU.g()) {
                    long j = millis2 + jA;
                    if (j < millis + jD) {
                        eh2.a aVarW0 = this.c.w0();
                        if (j >= jD) {
                            aVarW0.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jA > 86400000 && f()) {
                            aVarW0.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new vp(null, aVarW0.c());
                    }
                }
                String str2 = this.k;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.f != null) {
                        str2 = this.g;
                    } else {
                        if (this.d == null) {
                            return new vp(this.b, null);
                        }
                        str2 = this.e;
                    }
                    str = "If-Modified-Since";
                }
                iw0.a aVarC = this.b.e().c();
                p31.c(str2);
                aVarC.c(str, str2);
                return new vp(this.b.h().h(aVarC.e()).b(), this.c);
            }
            return new vp(this.b, null);
        }

        private final long d() {
            eh2 eh2Var = this.c;
            p31.c(eh2Var);
            tp tpVarU = eh2Var.u();
            if (tpVarU.c() != -1) {
                return TimeUnit.SECONDS.toMillis(tpVarU.c());
            }
            Date date = this.h;
            if (date != null) {
                Date date2 = this.d;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f == null || this.c.G0().i().o() != null) {
                return 0L;
            }
            Date date3 = this.d;
            long time2 = date3 != null ? date3.getTime() : this.i;
            Date date4 = this.f;
            p31.c(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / ((long) 10);
            }
            return 0L;
        }

        private final boolean e(df2 df2Var) {
            return (df2Var.d("If-Modified-Since") == null && df2Var.d("If-None-Match") == null) ? false : true;
        }

        private final boolean f() {
            eh2 eh2Var = this.c;
            p31.c(eh2Var);
            return eh2Var.u().c() == -1 && this.h == null;
        }

        public final vp b() {
            vp vpVarC = c();
            return (vpVarC.b() == null || !this.b.b().i()) ? vpVarC : new vp(null, null);
        }
    }

    public vp(df2 df2Var, eh2 eh2Var) {
        this.a = df2Var;
        this.b = eh2Var;
    }

    public final eh2 a() {
        return this.b;
    }

    public final df2 b() {
        return this.a;
    }
}
