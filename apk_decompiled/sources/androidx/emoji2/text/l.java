package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import defpackage.b52;
import defpackage.o43;
import defpackage.tj1;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    private final tj1 a;
    private final char[] b;
    private final a c = new a(1024);
    private final Typeface d;

    static class a {
        private final SparseArray a;
        private m b;

        private a() {
            this(1);
        }

        a a(int i) {
            SparseArray sparseArray = this.a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i);
        }

        final m b() {
            return this.b;
        }

        void c(m mVar, int i, int i2) {
            a aVarA = a(mVar.b(i));
            if (aVarA == null) {
                aVarA = new a();
                this.a.put(mVar.b(i), aVarA);
            }
            if (i2 > i) {
                aVarA.c(mVar, i + 1, i2);
            } else {
                aVarA.b = mVar;
            }
        }

        a(int i) {
            this.a = new SparseArray(i);
        }
    }

    private l(Typeface typeface, tj1 tj1Var) {
        this.d = typeface;
        this.a = tj1Var;
        this.b = new char[tj1Var.k() * 2];
        a(tj1Var);
    }

    private void a(tj1 tj1Var) {
        int iK = tj1Var.k();
        for (int i = 0; i < iK; i++) {
            m mVar = new m(this, i);
            Character.toChars(mVar.f(), this.b, i * 2);
            h(mVar);
        }
    }

    public static l b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            o43.a("EmojiCompat.MetadataRepo.create");
            return new l(typeface, k.b(byteBuffer));
        } finally {
            o43.b();
        }
    }

    public char[] c() {
        return this.b;
    }

    public tj1 d() {
        return this.a;
    }

    int e() {
        return this.a.l();
    }

    a f() {
        return this.c;
    }

    Typeface g() {
        return this.d;
    }

    void h(m mVar) {
        b52.h(mVar, "emoji metadata cannot be null");
        b52.b(mVar.c() > 0, "invalid metadata codepoint length");
        this.c.c(mVar, 0, mVar.c() - 1);
    }
}
