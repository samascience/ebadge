package androidx.core.os;

import defpackage.tt1;

/* JADX INFO: loaded from: classes.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(String str) {
        super(tt1.e(str, "The operation has been canceled."));
    }
}
