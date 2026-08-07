package defpackage;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes4.dex */
public class t40 {
    private long a = 0;
    private long b;
    private b c;

    public interface a {
    }

    private static class b extends CountDownTimer {
        public b(long j, long j2) {
            super(j, j2);
        }

        void a(a aVar) {
        }

        void b(c cVar) {
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    public interface c {
    }

    public static t40 b() {
        return new t40();
    }

    public void a() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.cancel();
            this.c = null;
        }
        if (this.b <= 0) {
            this.b = this.a + 1000;
        }
        b bVar2 = new b(this.a, this.b);
        this.c = bVar2;
        bVar2.b(null);
        this.c.a(null);
    }

    public t40 c(long j) {
        this.b = j;
        return this;
    }

    public t40 d(long j) {
        this.a = j;
        return this;
    }

    public void e() {
        if (this.c == null) {
            a();
        }
        this.c.start();
    }
}
