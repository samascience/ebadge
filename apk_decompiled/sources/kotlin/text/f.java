package kotlin.text;

import defpackage.k81;
import defpackage.p31;
import defpackage.y70;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes4.dex */
final class f implements Iterator, k81 {
    private static final a f = new a(null);
    private final CharSequence a;
    private int b;
    private int c;
    private int d;
    private int e;

    private static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public f(CharSequence charSequence) {
        p31.f(charSequence, "string");
        this.a = charSequence;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = 0;
        int i = this.d;
        int i2 = this.c;
        this.c = this.e + i;
        return this.a.subSequence(i2, i).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        int i2;
        int i3 = this.b;
        if (i3 != 0) {
            return i3 == 1;
        }
        if (this.e < 0) {
            this.b = 2;
            return false;
        }
        int length = this.a.length();
        int length2 = this.a.length();
        for (int i4 = this.c; i4 < length2; i4++) {
            char cCharAt = this.a.charAt(i4);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i2 = i4 + 1) < this.a.length() && this.a.charAt(i2) == '\n') ? 2 : 1;
                length = i4;
                this.b = 1;
                this.e = i;
                this.d = length;
                return true;
            }
        }
        i = -1;
        this.b = 1;
        this.e = i;
        this.d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
