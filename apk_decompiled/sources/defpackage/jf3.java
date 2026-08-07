package defpackage;

import android.view.View;
import androidx.activity.R$id;

/* JADX INFO: loaded from: classes.dex */
public abstract class jf3 {
    public static final void a(View view, qu1 qu1Var) {
        p31.f(view, "<this>");
        p31.f(qu1Var, "onBackPressedDispatcherOwner");
        view.setTag(R$id.view_tree_on_back_pressed_dispatcher_owner, qu1Var);
    }
}
