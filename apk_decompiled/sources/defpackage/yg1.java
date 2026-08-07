package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R$attr;

/* JADX INFO: loaded from: classes3.dex */
public abstract class yg1 {
    private static final int[] a = {R.attr.theme, R$attr.theme};
    private static final int[] b = {R$attr.materialThemeOverlay};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    private static int b(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Context c(Context context, AttributeSet attributeSet, int i, int i2) {
        int iB = b(context, attributeSet, i, i2);
        boolean z = (context instanceof s30) && ((s30) context).c() == iB;
        if (iB == 0 || z) {
            return context;
        }
        s30 s30Var = new s30(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            s30Var.getTheme().applyStyle(iA, true);
        }
        return s30Var;
    }
}
