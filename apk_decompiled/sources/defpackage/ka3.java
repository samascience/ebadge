package defpackage;

import java.io.EOFException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ka3 {
    public static final boolean a(fo foVar) {
        p31.f(foVar, "<this>");
        try {
            fo foVar2 = new fo();
            foVar.D(foVar2, 0L, ga2.e(foVar.size(), 64L));
            for (int i = 0; i < 16 && !foVar2.H(); i++) {
                int iH0 = foVar2.H0();
                if (Character.isISOControl(iH0) && !Character.isWhitespace(iH0)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
