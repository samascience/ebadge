package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class qr2 extends fg {
    public qr2(RecyclerView.Adapter adapter) {
        super(adapter);
    }

    @Override // defpackage.fg
    protected Animator[] c(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0.0f)};
    }
}
