package com.google.android.gms.internal.common;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    c(int i) {
        super(4);
    }

    public final c c(Object obj) {
        super.a(obj);
        return this;
    }

    public final c d(Iterator it) {
        while (it.hasNext()) {
            super.a(it.next());
        }
        return this;
    }
}
