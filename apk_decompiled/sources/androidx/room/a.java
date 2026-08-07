package androidx.room;

import android.content.Context;
import defpackage.pw2;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public final pw2.c a;
    public final Context b;
    public final String c;
    public final RoomDatabase.c d;
    public final List e;
    public final boolean f;
    public final RoomDatabase.JournalMode g;
    public final Executor h;
    public final Executor i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    private final Set m;
    public final String n;
    public final File o;

    public a(Context context, String str, pw2.c cVar, RoomDatabase.c cVar2, List list, boolean z, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set set, String str2, File file) {
        this.a = cVar;
        this.b = context;
        this.c = str;
        this.d = cVar2;
        this.e = list;
        this.f = z;
        this.g = journalMode;
        this.h = executor;
        this.i = executor2;
        this.j = z2;
        this.k = z3;
        this.l = z4;
        this.m = set;
        this.n = str2;
        this.o = file;
    }

    public boolean a(int i, int i2) {
        if ((i > i2 && this.l) || !this.k) {
            return false;
        }
        Set set = this.m;
        return set == null || !set.contains(Integer.valueOf(i));
    }
}
