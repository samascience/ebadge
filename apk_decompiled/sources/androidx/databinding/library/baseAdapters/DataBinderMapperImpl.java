package androidx.databinding.library.baseAdapters;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import defpackage.v50;
import defpackage.w50;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends v50 {
    private static final SparseIntArray a = new SparseIntArray(0);

    @Override // defpackage.v50
    public List collectDependencies() {
        return new ArrayList(0);
    }

    @Override // defpackage.v50
    public ViewDataBinding getDataBinder(w50 w50Var, View view, int i) {
        if (a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // defpackage.v50
    public ViewDataBinding getDataBinder(w50 w50Var, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
