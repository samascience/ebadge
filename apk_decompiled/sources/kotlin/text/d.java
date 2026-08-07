package kotlin.text;

import defpackage.e31;
import defpackage.ga2;
import defpackage.k81;
import defpackage.or0;
import defpackage.p31;
import defpackage.rm2;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;

/* JADX INFO: loaded from: classes4.dex */
final class d implements rm2 {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final or0 d;

    public static final class a implements Iterator, k81 {
        private int a = -1;
        private int b;
        private int c;
        private e31 d;
        private int e;

        a() {
            int iG = ga2.g(d.this.b, 0, d.this.a.length());
            this.b = iG;
            this.c = iG;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0031 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:17:0x0098  */
        /* JADX WARN: Code duplicated, block: B:9:0x0023  */
        private final void a() {
            Pair pair;
            if (this.c < 0) {
                this.a = 0;
                this.d = null;
                return;
            }
            if (d.this.c > 0) {
                int i = this.e + 1;
                this.e = i;
                if (i >= d.this.c) {
                    this.d = new e31(this.b, w.Q(d.this.a));
                    this.c = -1;
                } else if (this.c > d.this.a.length() && (pair = (Pair) d.this.d.invoke(d.this.a, Integer.valueOf(this.c))) != null) {
                    int iIntValue = ((Number) pair.component1()).intValue();
                    int iIntValue2 = ((Number) pair.component2()).intValue();
                    this.d = ga2.k(this.b, iIntValue);
                    int i2 = iIntValue + iIntValue2;
                    this.b = i2;
                    this.c = i2 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.d = new e31(this.b, w.Q(d.this.a));
                    this.c = -1;
                }
            } else if (this.c > d.this.a.length()) {
                this.d = new e31(this.b, w.Q(d.this.a));
                this.c = -1;
            } else {
                int iIntValue3 = ((Number) pair.component1()).intValue();
                int iIntValue4 = ((Number) pair.component2()).intValue();
                this.d = ga2.k(this.b, iIntValue3);
                int i3 = iIntValue3 + iIntValue4;
                this.b = i3;
                this.c = i3 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.a = 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e31 next() {
            if (this.a == -1) {
                a();
            }
            if (this.a == 0) {
                throw new NoSuchElementException();
            }
            e31 e31Var = this.d;
            p31.d(e31Var, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.d = null;
            this.a = -1;
            return e31Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(CharSequence charSequence, int i, int i2, or0 or0Var) {
        p31.f(charSequence, "input");
        p31.f(or0Var, "getNextMatch");
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = or0Var;
    }

    @Override // defpackage.rm2
    public Iterator iterator() {
        return new a();
    }
}
