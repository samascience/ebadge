package defpackage;

import android.database.Cursor;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class o31 {
    private final y0 a;

    public o31(y0 y0Var) {
        this.a = y0Var;
    }

    public List a(Cursor cursor) {
        return this.a.loadAllAndCloseCursor(cursor);
    }

    public Object b(Cursor cursor) {
        return this.a.loadUniqueAndCloseCursor(cursor);
    }
}
