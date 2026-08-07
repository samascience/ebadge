package defpackage;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes3.dex */
public final class hv extends v13 {
    private final Typeface a;
    private final a b;
    private boolean c;

    public interface a {
        void a(Typeface typeface);
    }

    public hv(a aVar, Typeface typeface) {
        this.a = typeface;
        this.b = aVar;
    }

    private void d(Typeface typeface) {
        if (this.c) {
            return;
        }
        this.b.a(typeface);
    }

    @Override // defpackage.v13
    public void a(int i) {
        d(this.a);
    }

    @Override // defpackage.v13
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.c = true;
    }
}
