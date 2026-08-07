package defpackage;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class p60 implements rk1 {
    private final a a;

    public interface a {
        Class a();

        void b(Object obj);

        Object c(String str);
    }

    private static final class b implements y50 {
        private final String a;
        private final a b;
        private Object c;

        b(String str, a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // defpackage.y50
        public Class a() {
            return this.b.a();
        }

        @Override // defpackage.y50
        public void b() {
            try {
                this.b.b(this.c);
            } catch (IOException unused) {
            }
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
            try {
                Object objC = this.b.c(this.a);
                this.c = objC;
                aVar.f(objC);
            } catch (IllegalArgumentException e) {
                aVar.c(e);
            }
        }
    }

    public static final class c implements sk1 {
        private final a a = new a();

        class a implements a {
            a() {
            }

            @Override // p60.a
            public Class a() {
                return InputStream.class;
            }

            @Override // p60.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // p60.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new p60(this.a);
        }
    }

    public p60(a aVar) {
        this.a = aVar;
    }

    @Override // defpackage.rk1
    public boolean a(Object obj) {
        return obj.toString().startsWith("data:image");
    }

    @Override // defpackage.rk1
    public rk1.a b(Object obj, int i, int i2, rx1 rx1Var) {
        return new rk1.a(new nt1(obj), new b(obj.toString(), this.a));
    }
}
