package defpackage;

import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class qk1 {
    private final ze1 a;

    class a extends ze1 {
        a(long j) {
            super(j);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // defpackage.ze1
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(b bVar, Object obj) {
            bVar.c();
        }
    }

    static final class b {
        private static final Queue d = na3.e(0);
        private int a;
        private int b;
        private Object c;

        private b() {
        }

        static b a(Object obj, int i, int i2) {
            b bVar;
            Queue queue = d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b();
            }
            bVar.b(obj, i, i2);
            return bVar;
        }

        private void b(Object obj, int i, int i2) {
            this.c = obj;
            this.b = i;
            this.a = i2;
        }

        public void c() {
            Queue queue = d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.a == bVar.a && this.c.equals(bVar.c);
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }
    }

    public qk1(long j) {
        this.a = new a(j);
    }

    public Object a(Object obj, int i, int i2) {
        b bVarA = b.a(obj, i, i2);
        Object objG = this.a.g(bVarA);
        bVarA.c();
        return objG;
    }

    public void b(Object obj, int i, int i2, Object obj2) {
        this.a.k(b.a(obj, i, i2), obj2);
    }
}
