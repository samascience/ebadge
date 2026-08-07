package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.a;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class eu0 implements z43 {
    private final z43 b;

    public eu0(z43 z43Var) {
        this.b = (z43) z42.d(z43Var);
    }

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        if (obj instanceof eu0) {
            return this.b.equals(((eu0) obj).b);
        }
        return false;
    }

    @Override // defpackage.w81
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // defpackage.z43
    public qg2 transform(Context context, qg2 qg2Var, int i, int i2) {
        au0 au0Var = (au0) qg2Var.get();
        qg2 qiVar = new qi(au0Var.e(), a.c(context).f());
        qg2 qg2VarTransform = this.b.transform(context, qiVar, i, i2);
        if (!qiVar.equals(qg2VarTransform)) {
            qiVar.a();
        }
        au0Var.m(this.b, (Bitmap) qg2VarTransform.get());
        return qg2Var;
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
    }
}
