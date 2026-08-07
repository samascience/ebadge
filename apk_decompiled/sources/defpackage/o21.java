package defpackage;

import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class o21 {
    private final c a;

    private static class a implements c {
        private final InputConfiguration a;

        a(Object obj) {
            this.a = (InputConfiguration) obj;
        }

        @Override // o21.c
        public Object a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Objects.equals(this.a, ((c) obj).a());
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a.toString();
        }
    }

    private static final class b extends a {
        b(Object obj) {
            super(obj);
        }
    }

    private interface c {
        Object a();
    }

    private o21(c cVar) {
        this.a = cVar;
    }

    public static o21 b(Object obj) {
        if (obj == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 31 ? new o21(new b(obj)) : new o21(new a(obj));
    }

    public Object a() {
        return this.a.a();
    }

    public boolean equals(Object obj) {
        if (obj instanceof o21) {
            return this.a.equals(((o21) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
