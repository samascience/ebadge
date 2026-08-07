package pl.droidsonroids.gif;

import android.content.res.AssetManager;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    public static final class b extends e {
        private final AssetManager a;
        private final String b;

        public b(AssetManager assetManager, String str) {
            super();
            this.a = assetManager;
            this.b = str;
        }

        @Override // pl.droidsonroids.gif.e
        GifInfoHandle a() {
            return new GifInfoHandle(this.a.openFd(this.b));
        }
    }

    public static class c extends e {
        private final Resources a;
        private final int b;

        public c(Resources resources, int i) {
            super();
            this.a = resources;
            this.b = i;
        }

        @Override // pl.droidsonroids.gif.e
        GifInfoHandle a() {
            return new GifInfoHandle(this.a.openRawResourceFd(this.b));
        }
    }

    abstract GifInfoHandle a();

    private e() {
    }
}
