package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class m5 extends fg {
    private final float f;

    public m5(RecyclerView.Adapter adapter) {
        this(adapter, 0.0f);
    }

    @Override // defpackage.fg
    protected Animator[] c(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", this.f, 1.0f)};
    }

    public m5(RecyclerView.Adapter adapter, float f) {
        super(adapter);
        this.f = f;
    }
}
