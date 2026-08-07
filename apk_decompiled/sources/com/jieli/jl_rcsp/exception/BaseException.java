package com.jieli.jl_rcsp.exception;

/* JADX INFO: loaded from: classes3.dex */
abstract class BaseException extends Exception {
    public BaseException() {
    }

    public abstract int getErrorCode();

    public BaseException(String str) {
        super(str);
    }
}
