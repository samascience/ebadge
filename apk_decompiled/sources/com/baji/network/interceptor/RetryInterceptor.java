package com.baji.network.interceptor;

import defpackage.df2;
import defpackage.eh2;
import defpackage.l31;
import defpackage.p31;
import defpackage.y70;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class RetryInterceptor implements l31 {
    private final int maxRetries;
    private final long retryDelay;

    public RetryInterceptor() {
        this(0, 0L, 3, null);
    }

    @Override // defpackage.l31
    public eh2 intercept(l31.a aVar) throws InterruptedException, IOException {
        IOException iOException;
        p31.f(aVar, "chain");
        df2 df2VarRequest = aVar.request();
        int i = this.maxRetries;
        eh2 eh2Var = null;
        IOException e = null;
        if (i >= 0) {
            int i2 = 0;
            eh2 eh2VarA = null;
            while (true) {
                if (i2 > 0) {
                    try {
                        Thread.sleep(this.retryDelay);
                    } catch (IOException e2) {
                        e = e2;
                        if (i2 == this.maxRetries) {
                            throw e;
                        }
                    }
                }
                eh2VarA = aVar.a(df2VarRequest);
                if (eh2VarA.k0()) {
                    p31.c(eh2VarA);
                    return eh2VarA;
                }
                if (i2 == i) {
                    iOException = e;
                    eh2Var = eh2VarA;
                    break;
                }
                i2++;
            }
        } else {
            iOException = null;
        }
        if (eh2Var != null) {
            return eh2Var;
        }
        if (iOException != null) {
            throw iOException;
        }
        throw new IOException("Unknown error");
    }

    public RetryInterceptor(int i, long j) {
        this.maxRetries = i;
        this.retryDelay = j;
    }

    public /* synthetic */ RetryInterceptor(int i, long j, int i2, y70 y70Var) {
        this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? 1000L : j);
    }
}
