package defpackage;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class v50 {
    public List collectDependencies() {
        return Collections.emptyList();
    }

    public abstract ViewDataBinding getDataBinder(w50 w50Var, View view, int i);

    public abstract ViewDataBinding getDataBinder(w50 w50Var, View[] viewArr, int i);
}
