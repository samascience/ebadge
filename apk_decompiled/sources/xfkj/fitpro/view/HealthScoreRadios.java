package xfkj.fitpro.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class HealthScoreRadios extends FrameLayout {
    private RadioButton a;
    private RadioButton b;
    private RadioButton c;
    private RadioButton d;
    private RadioButton e;
    private int f;

    public HealthScoreRadios(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = getContext().obtainStyledAttributes(attributeSet, R$styleable.GradeRadioStyle).getInteger(0, 30);
        c(context);
    }

    private int a(int i) {
        return d.c(i);
    }

    private int b(RadioButton radioButton) {
        return radioButton.isChecked() ? a(this.f) : (int) (((double) a(this.f)) * 0.8d);
    }

    private void c(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_report_radios, (ViewGroup) null);
        addView(viewInflate);
        this.a = (RadioButton) viewInflate.findViewById(R.id.rad_s);
        this.b = (RadioButton) viewInflate.findViewById(R.id.rad_a);
        this.c = (RadioButton) viewInflate.findViewById(R.id.rad_b);
        this.d = (RadioButton) viewInflate.findViewById(R.id.rad_c);
        this.e = (RadioButton) viewInflate.findViewById(R.id.rad_f);
        d();
        this.e.setChecked(true);
    }

    private void d() {
        int iC = d.c(2.0f);
        int iB = b(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iB, iB);
        layoutParams.rightMargin = iC;
        layoutParams.gravity = 80;
        this.a.setLayoutParams(layoutParams);
        int iB2 = b(this.b);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iB2, iB2);
        layoutParams2.rightMargin = iC;
        layoutParams2.gravity = 80;
        this.b.setLayoutParams(layoutParams2);
        int iB3 = b(this.c);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(iB3, iB3);
        layoutParams3.rightMargin = iC;
        layoutParams3.gravity = 80;
        this.c.setLayoutParams(layoutParams3);
        int iB4 = b(this.d);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(iB4, iB4);
        layoutParams4.rightMargin = iC;
        layoutParams4.gravity = 80;
        this.d.setLayoutParams(layoutParams4);
        int iB5 = b(this.e);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iB5, iB5);
        layoutParams5.rightMargin = iC;
        layoutParams5.gravity = 80;
        this.e.setLayoutParams(layoutParams5);
    }
}
