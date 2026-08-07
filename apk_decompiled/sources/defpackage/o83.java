package defpackage;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public class o83 implements rk1 {
    private static final o83 a = new o83();

    public static class a implements sk1 {
        private static final a a = new a();

        public static a a() {
            return a;
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return o83.c();
        }
    }

    private static class b implements y50 {
        private final Object a;

        b(Object obj) {
            this.a = obj;
        }

        @Override // defpackage.y50
        public Class a() {
            return this.a.getClass();
        }

        @Override // defpackage.y50
        public void b() {
        }

        @Override // defpackage.y50
        public void cancel() {
        }

        @Override // defpackage.y50
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // defpackage.y50
        public void e(Priority priority, y50.a aVar) {
            aVar.f(this.a);
        }
    }

    public static o83 c() {
        return a;
    }

    @Override // defpackage.rk1
    public boolean a(Object obj) {
        return true;
    }

    @Override // defpackage.rk1
    public rk1.a b(Object obj, int i, int i2, rx1 rx1Var) {
        return new rk1.a(new nt1(obj), new b(obj));
    }
}
