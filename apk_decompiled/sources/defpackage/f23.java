package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class f23 extends f53 {

    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView a;

        a(TextView textView) {
            this.a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.a.setScaleX(fFloatValue);
            this.a.setScaleY(fFloatValue);
        }
    }

    private void f0(s53 s53Var) {
        View view = s53Var.b;
        if (view instanceof TextView) {
            s53Var.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // defpackage.f53
    public void f(s53 s53Var) {
        f0(s53Var);
    }

    @Override // defpackage.f53
    public void i(s53 s53Var) {
        f0(s53Var);
    }

    @Override // defpackage.f53
    public Animator m(ViewGroup viewGroup, s53 s53Var, s53 s53Var2) {
        if (s53Var == null || s53Var2 == null || !(s53Var.b instanceof TextView)) {
            return null;
        }
        View view = s53Var2.b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map map = s53Var.a;
        Map map2 = s53Var2.a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new a(textView));
        return valueAnimatorOfFloat;
    }
}
