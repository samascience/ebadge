package defpackage;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes3.dex */
public class s40 {
    private long a = 0;
    private long b;
    private a c;
    private c d;
    private b e;

    public interface a {
        void onFinish();
    }

    private static class b extends CountDownTimer {
        private a a;
        private c b;

        public b(long j, long j2) {
            super(j, j2);
        }

        void a(a aVar) {
            this.a = aVar;
        }

        void b(c cVar) {
            this.b = cVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            a aVar = this.a;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(j);
            }
        }
    }

    public interface c {
        void a(long j);
    }

    public static s40 c() {
        return new s40();
    }

    public void a() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.cancel();
        }
    }

    public void b() {
        b bVar = this.e;
        if (bVar != null) {
            bVar.cancel();
            this.e = null;
        }
        if (this.b <= 0) {
            this.b = this.a + 1000;
        }
        b bVar2 = new b(this.a, this.b);
        this.e = bVar2;
        bVar2.b(this.d);
        this.e.a(this.c);
    }

    public s40 d(long j) {
        this.b = j;
        return this;
    }

    public s40 e(a aVar) {
        this.c = aVar;
        return this;
    }

    public s40 f(long j) {
        this.a = j;
        return this;
    }

    public s40 g(c cVar) {
        this.d = cVar;
        return this;
    }

    public void h() {
        if (this.e == null) {
            b();
        }
        this.e.start();
    }
}
