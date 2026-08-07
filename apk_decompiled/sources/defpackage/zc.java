package defpackage;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
final class zc extends w80.b {
    private final int a;
    private final int b;
    private final CallbackToFutureAdapter.a c;

    zc(int i, int i2, CallbackToFutureAdapter.a aVar) {
        this.a = i;
        this.b = i2;
        if (aVar == null) {
            throw new NullPointerException("Null completer");
        }
        this.c = aVar;
    }

    @Override // w80.b
    CallbackToFutureAdapter.a a() {
        return this.c;
    }

    @Override // w80.b
    int b() {
        return this.a;
    }

    @Override // w80.b
    int c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w80.b)) {
            return false;
        }
        w80.b bVar = (w80.b) obj;
        return this.a == bVar.b() && this.b == bVar.c() && this.c.equals(bVar.a());
    }

    public int hashCode() {
        return ((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "PendingSnapshot{jpegQuality=" + this.a + ", rotationDegrees=" + this.b + ", completer=" + this.c + "}";
    }
}
