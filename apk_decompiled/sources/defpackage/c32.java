package defpackage;

import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class c32 implements b32 {
    private static final String a = "c32";

    class a implements ew1 {
        a() {
        }

        @Override // defpackage.ew1
        public void a(List list) {
            Log.i(c32.a, "onResult:" + list.size());
        }

        @Override // defpackage.ew1
        public void onCancel() {
            Log.i(c32.a, "PictureSelector onCancel");
        }
    }

    @Override // defpackage.b32
    public k01 a() {
        return mu0.e();
    }

    @Override // defpackage.b32
    public ew1 b() {
        return new a();
    }
}
