package defpackage;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.a;
import com.bumptech.glide.e;
import com.bumptech.glide.f;
import com.legend.sdk.cameralibray.R$mipmap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ru0 {
    public static void a(Context context, String str, int i, ImageView imageView, ri riVar) {
        b(context, str, i, imageView, riVar, null);
    }

    public static void b(Context context, String str, int i, ImageView imageView, ri riVar, if2 if2Var) {
        try {
            f fVarU = a.u(context);
            of2 of2Var = new of2();
            of2Var.f(ac0.a);
            if (i != -1) {
                of2Var.h(i);
                of2Var.U(i);
            }
            of2Var.c();
            if (riVar != null) {
                of2Var.e0(riVar);
            }
            e eVarR = fVarU.r(str);
            if (if2Var != null) {
                eVarR.j0(if2Var);
            }
            eVarR.a(of2Var).u0(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(Context context, String str, ImageView imageView) {
        a(context, str, R$mipmap.default_load_img, imageView, null);
    }
}
