package defpackage;

import com.arthenica.ffmpegkit.FFmpegKitConfig;
import com.arthenica.ffmpegkit.LogRedirectionStrategy;
import com.arthenica.ffmpegkit.a;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yj0 extends a implements in2 {
    private final wt2 o;
    private final zj0 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final List f447q;
    private final Object r;

    private yj0(String[] strArr, zj0 zj0Var, ad1 ad1Var, wt2 wt2Var, LogRedirectionStrategy logRedirectionStrategy) {
        super(strArr, ad1Var, logRedirectionStrategy);
        this.p = zj0Var;
        this.o = wt2Var;
        this.f447q = new LinkedList();
        this.r = new Object();
    }

    public static yj0 u(String[] strArr) {
        return new yj0(strArr, null, null, null, FFmpegKitConfig.i());
    }

    public static yj0 v(String[] strArr, zj0 zj0Var) {
        return new yj0(strArr, zj0Var, null, null, FFmpegKitConfig.i());
    }

    public static yj0 w(String[] strArr, zj0 zj0Var, ad1 ad1Var, wt2 wt2Var) {
        return new yj0(strArr, zj0Var, ad1Var, wt2Var, FFmpegKitConfig.i());
    }

    @Override // defpackage.in2
    public boolean a() {
        return true;
    }

    public void t(vt2 vt2Var) {
        synchronized (this.r) {
            this.f447q.add(vt2Var);
        }
    }

    public String toString() {
        return "FFmpegSession{sessionId=" + this.a + ", createTime=" + this.c + ", startTime=" + this.d + ", endTime=" + this.e + ", arguments=" + FFmpegKitConfig.c(this.f) + ", logs=" + l() + ", state=" + this.j + ", returnCode=" + this.k + ", failStackTrace='" + this.l + "'}";
    }

    public zj0 x() {
        return this.p;
    }

    public wt2 y() {
        return this.o;
    }
}
