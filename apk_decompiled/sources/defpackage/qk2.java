package defpackage;

import android.view.ViewGroup;
import androidx.transition.R$id;

/* JADX INFO: loaded from: classes.dex */
public abstract class qk2 {
    public static qk2 a(ViewGroup viewGroup) {
        e43.a(viewGroup.getTag(R$id.transition_current_scene));
        return null;
    }

    static void b(ViewGroup viewGroup, qk2 qk2Var) {
        viewGroup.setTag(R$id.transition_current_scene, qk2Var);
    }
}
