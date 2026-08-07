package androidx.databinding;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import defpackage.v50;
import defpackage.w50;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    private static v50 a = new DataBinderMapperImpl();

    static ViewDataBinding a(w50 w50Var, View view, int i) {
        return a.getDataBinder(w50Var, view, i);
    }

    static ViewDataBinding b(w50 w50Var, View[] viewArr, int i) {
        return a.getDataBinder(w50Var, viewArr, i);
    }

    private static ViewDataBinding c(w50 w50Var, ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        if (i3 == 1) {
            return a(w50Var, viewGroup.getChildAt(childCount - 1), i2);
        }
        View[] viewArr = new View[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            viewArr[i4] = viewGroup.getChildAt(i4 + i);
        }
        return b(w50Var, viewArr, i2);
    }

    public static w50 d() {
        return null;
    }

    public static ViewDataBinding e(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, i, viewGroup, z, null);
    }

    public static ViewDataBinding f(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z, w50 w50Var) {
        boolean z2 = viewGroup != null && z;
        return z2 ? c(w50Var, viewGroup, z2 ? viewGroup.getChildCount() : 0, i) : a(w50Var, layoutInflater.inflate(i, viewGroup, z), i);
    }

    public static ViewDataBinding g(Activity activity, int i) {
        return h(activity, i, null);
    }

    public static ViewDataBinding h(Activity activity, int i, w50 w50Var) {
        activity.setContentView(i);
        return c(w50Var, (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content), 0, i);
    }
}
