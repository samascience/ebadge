package com.yalantis.ucrop.view.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.luck.picture.lib.R$color;
import com.luck.picture.lib.R$dimen;
import com.luck.picture.lib.R$styleable;
import com.yalantis.ucrop.model.AspectRatio;
import defpackage.q30;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class AspectRatioTextView extends AppCompatTextView {
    private final float h;
    private final Rect i;
    private Paint j;
    private int k;
    private float l;
    private String m;
    private float n;
    private float o;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    private void q(int i) {
        Paint paint = this.j;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{0}}, new int[]{i, q30.c(getContext(), R$color.ucrop_color_widget)}));
    }

    private void s(TypedArray typedArray) {
        setGravity(1);
        this.m = typedArray.getString(R$styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title);
        this.n = typedArray.getFloat(R$styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x, 0.0f);
        float f = typedArray.getFloat(R$styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y, 0.0f);
        this.o = f;
        float f2 = this.n;
        if (f2 == 0.0f || f == 0.0f) {
            this.l = 0.0f;
        } else {
            this.l = f2 / f;
        }
        this.k = getContext().getResources().getDimensionPixelSize(R$dimen.ucrop_size_dot_scale_text_view);
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setStyle(Paint.Style.FILL);
        t();
        q(getResources().getColor(R$color.ucrop_color_widget_active));
        typedArray.recycle();
    }

    private void t() {
        if (TextUtils.isEmpty(this.m)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.n), Integer.valueOf((int) this.o)));
        } else {
            setText(this.m);
        }
    }

    private void u() {
        if (this.l != 0.0f) {
            float f = this.n;
            float f2 = this.o;
            this.n = f2;
            this.o = f;
            this.l = f2 / f;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.i);
            Rect rect = this.i;
            float f = (rect.right - rect.left) / 2.0f;
            float f2 = rect.bottom - (rect.top / 2.0f);
            int i = this.k;
            canvas.drawCircle(f, f2 - (i * 1.5f), i / 2.0f, this.j);
        }
    }

    public float r(boolean z) {
        if (z) {
            u();
            t();
        }
        return this.l;
    }

    public void setActiveColor(int i) {
        q(i);
        invalidate();
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        this.m = aspectRatio.a();
        this.n = aspectRatio.b();
        float fC = aspectRatio.c();
        this.o = fC;
        float f = this.n;
        if (f == 0.0f || fC == 0.0f) {
            this.l = 0.0f;
        } else {
            this.l = f / fC;
        }
        t();
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 1.5f;
        this.i = new Rect();
        s(context.obtainStyledAttributes(attributeSet, R$styleable.ucrop_AspectRatioTextView));
    }
}
