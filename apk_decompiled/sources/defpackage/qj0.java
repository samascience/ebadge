package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class qj0 {
    private static final Object a = new Object();
    private static final Map b = new HashMap();

    public static ct a(Object obj) {
        ct ctVar;
        synchronized (a) {
            ctVar = (ct) b.get(obj);
        }
        return ctVar == null ? ct.a : ctVar;
    }
}
