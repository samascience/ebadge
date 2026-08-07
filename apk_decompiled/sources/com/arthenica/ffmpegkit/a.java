package com.arthenica.ffmpegkit;

import android.util.Log;
import defpackage.ad1;
import defpackage.in2;
import defpackage.mi0;
import defpackage.sh2;
import defpackage.zc1;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements in2 {
    protected static final AtomicLong n = new AtomicLong(1);
    protected final ad1 b;
    protected final String[] f;
    protected final LogRedirectionStrategy m;
    protected final long a = n.getAndIncrement();
    protected final Date c = new Date();
    protected Date d = null;
    protected Date e = null;
    protected final List g = new LinkedList();
    protected final Object h = new Object();
    protected Future i = null;
    protected SessionState j = SessionState.CREATED;
    protected sh2 k = null;
    protected String l = null;

    protected a(String[] strArr, ad1 ad1Var, LogRedirectionStrategy logRedirectionStrategy) {
        this.b = ad1Var;
        this.f = strArr;
        this.m = logRedirectionStrategy;
        FFmpegKitConfig.b(this);
    }

    @Override // defpackage.in2
    public void b(zc1 zc1Var) {
        synchronized (this.h) {
            this.g.add(zc1Var);
        }
    }

    @Override // defpackage.in2
    public LogRedirectionStrategy c() {
        return this.m;
    }

    @Override // defpackage.in2
    public ad1 d() {
        return this.b;
    }

    @Override // defpackage.in2
    public long e() {
        return this.a;
    }

    void f(sh2 sh2Var) {
        this.k = sh2Var;
        this.j = SessionState.COMPLETED;
        this.e = new Date();
    }

    void g(Exception exc) {
        this.l = mi0.a(exc);
        this.j = SessionState.FAILED;
        this.e = new Date();
    }

    public String h() {
        return i(5000);
    }

    public String i(int i) {
        s(i);
        if (r()) {
            Log.i("ffmpeg-kit", String.format("getAllLogsAsString was called to return all logs but there are still logs being transmitted for session id %d.", Long.valueOf(this.a)));
        }
        return l();
    }

    public String[] j() {
        return this.f;
    }

    public String k() {
        return this.l;
    }

    public String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.h) {
            try {
                Iterator it = this.g.iterator();
                while (it.hasNext()) {
                    sb.append(((zc1) it.next()).a());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb.toString();
    }

    public String m() {
        return h();
    }

    public sh2 n() {
        return this.k;
    }

    public SessionState o() {
        return this.j;
    }

    void p(Future future) {
        this.i = future;
    }

    void q() {
        this.j = SessionState.RUNNING;
        this.d = new Date();
    }

    public boolean r() {
        return FFmpegKitConfig.messagesInTransmit(this.a) != 0;
    }

    protected void s(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (r() && System.currentTimeMillis() < ((long) i) + jCurrentTimeMillis) {
            synchronized (this) {
                try {
                    wait(100L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }
}
