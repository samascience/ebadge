package defpackage;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ap implements rk1 {
    private final b a;

    public static class a implements sk1 {

        /* JADX INFO: renamed from: ap$a$a, reason: collision with other inner class name */
        class C0045a implements b {
            C0045a() {
            }

            @Override // ap.b
            public Class a() {
                return ByteBuffer.class;
            }

            @Override // ap.b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new ap(new C0045a());
        }
    }

    public interface b {
        Class a();

        Object b(byte[] bArr);
    }

    private static class c implements y50 {
        private final byte[] a;
        private final b b;

        c(byte[] bArr, b bVar) {
            this.a = bArr;
            this.b = bVar;
        }

        @Override // defpackage.y50
        public Class a() {
            return this.b.a();
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
            aVar.f(this.b.b(this.a));
        }
    }

    public static class d implements sk1 {

        class a implements b {
            a() {
            }

            @Override // ap.b
            public Class a() {
                return InputStream.class;
            }

            @Override // ap.b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new ap(new a());
        }
    }

    public ap(b bVar) {
        this.a = bVar;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(byte[] bArr, int i, int i2, rx1 rx1Var) {
        return new rk1.a(new nt1(bArr), new c(bArr, this.a));
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(byte[] bArr) {
        return true;
    }
}
