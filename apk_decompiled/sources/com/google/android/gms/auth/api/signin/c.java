package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final /* synthetic */ class c implements Comparator {
    static final Comparator a = new c();

    private c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Scope) obj).F0().compareTo(((Scope) obj2).F0());
    }
}
