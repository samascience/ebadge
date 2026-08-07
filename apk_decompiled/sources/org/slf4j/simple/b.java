package org.slf4j.simple;

import defpackage.hd1;
import defpackage.iy0;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
public class b implements iy0 {
    ConcurrentMap a = new ConcurrentHashMap();

    public b() {
        SimpleLogger.lazyInit();
    }

    @Override // defpackage.iy0
    public hd1 a(String str) {
        hd1 hd1Var = (hd1) this.a.get(str);
        if (hd1Var != null) {
            return hd1Var;
        }
        SimpleLogger simpleLogger = new SimpleLogger(str);
        hd1 hd1Var2 = (hd1) this.a.putIfAbsent(str, simpleLogger);
        return hd1Var2 == null ? simpleLogger : hd1Var2;
    }
}
