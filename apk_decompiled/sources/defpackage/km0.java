package defpackage;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class km0 implements rk1 {
    private final d a;

    public static class a implements sk1 {
        private final d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // defpackage.sk1
        public final rk1 b(zl1 zl1Var) {
            return new km0(this.a);
        }
    }

    public static class b extends a {

        class a implements d {
            a() {
            }

            @Override // km0.d
            public Class a() {
                return ParcelFileDescriptor.class;
            }

            @Override // km0.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // km0.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor c(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    private static final class c implements y50 {
        private final File a;
        private final d b;
        private Object c;

        c(File file, d dVar) {
            this.a = file;
            this.b = dVar;
        }

        @Override // defpackage.y50
        public Class a() {
            return this.b.a();
        }

        @Override // defpackage.y50
        public void b() {
            Object obj = this.c;
            if (obj != null) {
                try {
                    this.b.b(obj);
                } catch (IOException unused) {
                }
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
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                aVar.c(e);
            }
        }
    }

    public interface d {
        Class a();

        void b(Object obj);

        Object c(File file);
    }

    public static class e extends a {

        class a implements d {
            a() {
            }

            @Override // km0.d
            public Class a() {
                return InputStream.class;
            }

            @Override // km0.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // km0.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(File file) {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public km0(d dVar) {
        this.a = dVar;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(File file, int i, int i2, rx1 rx1Var) {
        return new rk1.a(new nt1(file), new c(file, this.a));
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }
}
