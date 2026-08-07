package com.google.android.gms.tasks;

import defpackage.u03;

/* JADX INFO: loaded from: classes.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException of(u03 u03Var) {
        String strConcat;
        if (!u03Var.f()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excB = u03Var.b();
        if (excB != null) {
            strConcat = "failure";
        } else if (u03Var.g()) {
            strConcat = "result ".concat(String.valueOf(u03Var.c()));
        } else {
            strConcat = u03Var.e() ? "cancellation" : "unknown issue";
        }
        return new DuplicateTaskCompletionException("Complete with: ".concat(strConcat), excB);
    }
}
