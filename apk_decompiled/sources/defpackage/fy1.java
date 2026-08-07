package defpackage;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
public abstract class fy1 {
    private final b a;

    static abstract class a {
        final b.a a;

        a(b.a aVar) {
            this.a = aVar;
            aVar.b(0L);
            aVar.a(0L);
        }
    }

    static abstract class b {

        static abstract class a {
            a() {
            }

            abstract Object a(long j);

            abstract Object b(long j);
        }

        b() {
        }

        abstract long a();

        abstract long b();

        abstract Location c();
    }

    fy1(b bVar) {
        this.a = bVar;
    }

    public long a() {
        return this.a.a();
    }

    public long b() {
        return this.a.b();
    }

    public Location c() {
        return this.a.c();
    }
}
