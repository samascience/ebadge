package defpackage;

import android.window.BackEvent;

/* JADX INFO: loaded from: classes.dex */
public final class he {
    public static final a e = new a(null);
    private final float a;
    private final float b;
    private final float c;
    private final int d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public he(float f, float f2, float f3, int i) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = i;
    }

    public final float a() {
        return this.c;
    }

    public final int b() {
        return this.d;
    }

    public final float c() {
        return this.b;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.a + ", touchY=" + this.b + ", progress=" + this.c + ", swipeEdge=" + this.d + '}';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public he(BackEvent backEvent) {
        p31.f(backEvent, "backEvent");
        u7 u7Var = u7.a;
        this(u7Var.d(backEvent), u7Var.e(backEvent), u7Var.b(backEvent), u7Var.c(backEvent));
    }
}
