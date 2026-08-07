package defpackage;

import android.util.Range;
import android.util.Size;

/* JADX INFO: loaded from: classes.dex */
public abstract class jh0 {
    public static eh0.c a(eh0.c cVar, Size size, Range range) {
        return eh0.c.a(cVar.e(), cVar.i(), yb3.e(cVar.c(), cVar.b(), cVar.b(), cVar.f(), cVar.f(), size.getWidth(), cVar.k(), size.getHeight(), cVar.h(), range), cVar.f(), size.getWidth(), size.getHeight(), cVar.j(), cVar.b(), cVar.d(), cVar.g());
    }

    public static eh0.c b(eh0 eh0Var) {
        if (eh0Var == null || eh0Var.d().isEmpty()) {
            return null;
        }
        return (eh0.c) eh0Var.d().get(0);
    }
}
