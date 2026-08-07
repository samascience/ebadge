package defpackage;

import android.content.res.AssetManager;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class wa implements rk1 {
    private static final int c = 22;
    private final AssetManager a;
    private final a b;

    public interface a {
        y50 a(AssetManager assetManager, String str);
    }

    public static class b implements sk1, a {
        private final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // wa.a
        public y50 a(AssetManager assetManager, String str) {
            return new fm0(assetManager, str);
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new wa(this.a, this);
        }
    }

    public static class c implements sk1, a {
        private final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // wa.a
        public y50 a(AssetManager assetManager, String str) {
            return new vu2(assetManager, str);
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new wa(this.a, this);
        }
    }

    public wa(AssetManager assetManager, a aVar) {
        this.a = assetManager;
        this.b = aVar;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(Uri uri, int i, int i2, rx1 rx1Var) {
        return new rk1.a(new nt1(uri), this.b.a(this.a, uri.toString().substring(c)));
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
