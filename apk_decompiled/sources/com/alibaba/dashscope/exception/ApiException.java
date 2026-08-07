package com.alibaba.dashscope.exception;

import com.alibaba.dashscope.common.ErrorType;
import defpackage.t71;
import defpackage.uv2;
import defpackage.xt2;

/* JADX INFO: loaded from: classes.dex */
public class ApiException extends RuntimeException {
    private xt2 status;

    public ApiException(Throwable th) {
        super(th);
        this.status = null;
        if (th instanceof ApiException) {
            this.status = ((ApiException) th).status;
        } else {
            this.status = xt2.c().f(-1).b(ErrorType.NETWORK_ERROR.getValue()).d(uv2.a("%s: %s", th.getClass().getSimpleName(), th.getMessage())).a();
        }
        setStackTrace(th.getStackTrace());
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return t71.toJson(this.status);
    }

    public xt2 getStatus() {
        return this.status;
    }

    public void setStatus(xt2 xt2Var) {
        this.status = xt2Var;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; status body:" + t71.toJson(this.status);
    }

    public ApiException(xt2 xt2Var) {
        this.status = xt2Var;
    }

    public ApiException(xt2 xt2Var, Throwable th) {
        super(xt2Var.f(), th);
        this.status = xt2Var;
    }
}
