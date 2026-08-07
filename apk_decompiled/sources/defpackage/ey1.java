package defpackage;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
abstract class ey1 implements zx1.a {
    final Object a;

    ey1(Object obj) {
        this.a = obj;
    }

    @Override // zx1.a
    public void b(long j) {
    }

    public boolean equals(Object obj) {
        if (obj instanceof ey1) {
            return Objects.equals(this.a, ((ey1) obj).a);
        }
        return false;
    }

    @Override // zx1.a
    public void h(int i) {
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
