package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.a;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class id0 implements z43 {
    private final z43 b;
    private final boolean c;

    public id0(z43 z43Var, boolean z) {
        this.b = z43Var;
        this.c = z;
    }

    private qg2 b(Context context, qg2 qg2Var) {
        return ka1.d(context.getResources(), qg2Var);
    }

    public z43 a() {
        return this;
    }

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        if (obj instanceof id0) {
            return this.b.equals(((id0) obj).b);
        }
        return false;
    }

    @Override // defpackage.w81
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // defpackage.z43
    public qg2 transform(Context context, qg2 qg2Var, int i, int i2) {
        oi oiVarF = a.c(context).f();
        Drawable drawable = (Drawable) qg2Var.get();
        qg2 qg2VarA = hd0.a(oiVarF, drawable, i, i2);
        if (qg2VarA != null) {
            qg2 qg2VarTransform = this.b.transform(context, qg2VarA, i, i2);
            if (!qg2VarTransform.equals(qg2VarA)) {
                return b(context, qg2VarTransform);
            }
            qg2VarTransform.a();
            return qg2Var;
        }
        if (!this.c) {
            return qg2Var;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
    }
}
