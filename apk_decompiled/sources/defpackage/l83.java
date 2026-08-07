package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class l83 implements ug2 {

    private static final class a implements qg2 {
        private final Bitmap a;

        a(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // defpackage.qg2
        public void a() {
        }

        @Override // defpackage.qg2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.a;
        }

        @Override // defpackage.qg2
        public int o() {
            return na3.g(this.a);
        }

        @Override // defpackage.qg2
        public Class p() {
            return Bitmap.class;
        }
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public qg2 b(Bitmap bitmap, int i, int i2, rx1 rx1Var) {
        return new a(bitmap);
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Bitmap bitmap, rx1 rx1Var) {
        return true;
    }
}
