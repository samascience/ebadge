package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class m31 extends dc0 {

    class a implements dc0.a {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // dc0.a
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }

    public m31(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public m31(Context context, String str, long j) {
        super(new a(context, str), j);
    }
}
