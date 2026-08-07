package com.bumptech.glide;

import defpackage.gr1;
import defpackage.m53;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements Cloneable {
    private m53 a = gr1.b();

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final g clone() {
        try {
            return (g) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    final m53 b() {
        return this.a;
    }
}
