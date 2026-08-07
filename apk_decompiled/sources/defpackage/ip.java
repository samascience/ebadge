package defpackage;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ip implements rk1 {

    private static final class a implements y50 {
        private final File a;

        a(File file) {
            this.a = file;
        }

        @Override // defpackage.y50
        public Class a() {
            return ByteBuffer.class;
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
            try {
                aVar.f(lp.a(this.a));
            } catch (IOException e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                aVar.c(e);
            }
        }
    }

    public static class b implements sk1 {
        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new ip();
        }
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(File file, int i, int i2, rx1 rx1Var) {
        return new rk1.a(new nt1(file), new a(file));
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }
}
