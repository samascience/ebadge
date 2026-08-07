package defpackage;

import android.util.Range;

/* JADX INFO: loaded from: classes.dex */
public interface pc3 extends bh0 {
    default boolean a(int i, int i2) {
        return i(i, i2) || (d() && i(i2, i));
    }

    int b();

    Range c();

    boolean d();

    Range e(int i);

    Range f(int i);

    int g();

    Range h();

    boolean i(int i, int i2);

    Range j();
}
