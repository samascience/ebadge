package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class b7 {
    public static Animator a(Context context, int i) {
        return AnimatorInflater.loadAnimator(context, i);
    }
}
