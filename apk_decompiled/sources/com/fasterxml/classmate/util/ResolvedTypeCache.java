package com.fasterxml.classmate.util;

import defpackage.og2;
import defpackage.pg2;
import defpackage.u63;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResolvedTypeCache implements Serializable {
    public static ResolvedTypeCache concurrentCache(int i) {
        return new ConcurrentTypeCache(i);
    }

    public static ResolvedTypeCache lruCache(int i) {
        return new LRUTypeCache(i);
    }

    protected void _addForTest(og2 og2Var) {
        put(key(og2Var.g(), (og2[]) og2Var.m().toArray(new og2[0])), og2Var);
    }

    public abstract og2 find(pg2 pg2Var);

    public pg2 key(Class<?> cls) {
        return new pg2(cls);
    }

    public abstract void put(pg2 pg2Var, og2 og2Var);

    public abstract int size();

    public pg2 key(Class<?> cls, og2[] og2VarArr) {
        int length = og2VarArr == null ? 0 : og2VarArr.length;
        if (length == 0) {
            return new pg2(cls);
        }
        for (int i = 0; i < length; i++) {
            if (og2VarArr[i] instanceof u63) {
                return null;
            }
        }
        return new pg2(cls, og2VarArr);
    }
}
