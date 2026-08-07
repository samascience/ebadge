package xfkj.fitpro.view.numberprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import com.jieli.jl_rcsp.constant.Command;
import com.tencent.connect.common.Constants;
import defpackage.vv1;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class NumberProgressBar extends View {
    private float F;
    private boolean G;
    private boolean H;
    private boolean I;
    private RectF J;
    private Paint K;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private float f;
    private float g;
    private float h;
    private String i;
    private String j;
    private final int k;
    private final int l;
    private final int m;
    private final float n;
    private final float o;
    private final float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final float f440q;
    private float r;
    private float s;
    private float t;
    private String u;
    private Paint v;
    private Paint w;
    private Paint x;
    private RectF y;
    private RectF z;

    public enum ProgressTextVisibility {
        Visible,
        Invisible
    }

    public NumberProgressBar(Context context) {
        this(context, null);
    }

    private void a() {
        this.u = String.format("%d", Integer.valueOf((getProgress() * 100) / getMax()));
        String str = this.j + this.u + this.i;
        this.u = str;
        this.r = this.x.measureText(str);
        if (getProgress() == 0) {
            this.H = false;
            this.s = getPaddingLeft();
        } else {
            this.H = true;
            this.z.left = getPaddingLeft();
            this.z.top = (getHeight() / 2.0f) - (this.g / 2.0f);
            this.z.right = (((((getWidth() - getPaddingLeft()) - getPaddingRight()) / (getMax() * 1.0f)) * getProgress()) - this.F) + getPaddingLeft();
            this.z.bottom = (getHeight() / 2.0f) + (this.g / 2.0f);
            this.s = this.z.right + this.F;
        }
        this.t = (int) ((getHeight() / 2.0f) - ((this.x.descent() + this.x.ascent()) / 2.0f));
        if (this.s + this.r >= getWidth() - getPaddingRight()) {
            float width = (getWidth() - getPaddingRight()) - this.r;
            this.s = width;
            this.z.right = width - this.F;
        }
        if (this.s + this.r + this.F >= getWidth() - getPaddingRight()) {
            this.G = false;
        } else {
            this.G = true;
            this.y.left = getPaddingLeft();
            this.y.right = getWidth() - getPaddingRight();
            this.y.top = (getHeight() / 2.0f) + ((-this.h) / 2.0f);
            this.y.bottom = (getHeight() / 2.0f) + (this.h / 2.0f);
        }
        float f = this.r;
        float f2 = this.s + (f / 2.0f);
        RectF rectF = this.J;
        rectF.left = f2 - f;
        rectF.right = f2 + f;
        rectF.top = (getHeight() / 2.0f) + ((-this.h) / 2.0f);
        this.J.bottom = (getHeight() / 2.0f) + (this.h / 2.0f);
    }

    private void b() {
        this.z.left = getPaddingLeft();
        this.z.top = (getHeight() / 2.0f) - (this.g / 2.0f);
        this.z.right = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) / (getMax() * 1.0f)) * getProgress()) + getPaddingLeft();
        this.z.bottom = (getHeight() / 2.0f) + (this.g / 2.0f);
        RectF rectF = this.y;
        rectF.left = this.z.left;
        rectF.right = getWidth() - getPaddingRight();
        this.y.top = (getHeight() / 2.0f) + ((-this.h) / 2.0f);
        this.y.bottom = (getHeight() / 2.0f) + (this.h / 2.0f);
    }

    private void d() {
        Paint paint = new Paint(1);
        this.v = paint;
        paint.setColor(this.c);
        Paint paint2 = new Paint(1);
        this.w = paint2;
        paint2.setColor(this.d);
        Paint paint3 = new Paint(1);
        this.x = paint3;
        paint3.setColor(this.e);
        this.x.setTextSize(this.f);
        Paint paint4 = new Paint(1);
        this.K = paint4;
        paint4.setColor(-1);
    }

    private int e(int i, boolean z) {
        int paddingTop;
        int paddingBottom;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (z) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i2 = paddingTop + paddingBottom;
        if (mode == 1073741824) {
            return size;
        }
        int suggestedMinimumWidth = (z ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight()) + i2;
        if (mode == Integer.MIN_VALUE) {
            return z ? Math.max(suggestedMinimumWidth, size) : Math.min(suggestedMinimumWidth, size);
        }
        return suggestedMinimumWidth;
    }

    public float c(float f) {
        return (f * getResources().getDisplayMetrics().density) + 0.5f;
    }

    public float f(float f) {
        return f * getResources().getDisplayMetrics().scaledDensity;
    }

    public int getMax() {
        return this.a;
    }

    public String getPrefix() {
        return this.j;
    }

    public int getProgress() {
        return this.b;
    }

    public float getProgressTextSize() {
        return this.f;
    }

    public boolean getProgressTextVisibility() {
        return this.I;
    }

    public int getReachedBarColor() {
        return this.c;
    }

    public float getReachedBarHeight() {
        return this.g;
    }

    public String getSuffix() {
        return this.i;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max((int) this.f, Math.max((int) this.g, (int) this.h));
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return (int) this.f;
    }

    public int getTextColor() {
        return this.e;
    }

    public int getUnreachedBarColor() {
        return this.d;
    }

    public float getUnreachedBarHeight() {
        return this.h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.I) {
            a();
        } else {
            b();
        }
        int height = getHeight() / 2;
        if (this.G) {
            float f = height;
            canvas.drawRoundRect(this.y, f, f, this.w);
        }
        if (this.H) {
            float f2 = height;
            canvas.drawRoundRect(this.z, f2, f2, this.v);
        }
        if (this.I) {
            this.K.setShadowLayer(5.0f, 0.0f, 0.0f, -7829368);
            float f3 = height;
            canvas.drawRoundRect(this.J, f3, f3, this.K);
            canvas.drawText(this.u, this.s, this.t, this.x);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(e(i, true), e(i2, false));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.e = bundle.getInt("text_color");
        this.f = bundle.getFloat("text_size");
        this.g = bundle.getFloat("reached_bar_height");
        this.h = bundle.getFloat("unreached_bar_height");
        this.c = bundle.getInt("reached_bar_color");
        this.d = bundle.getInt("unreached_bar_color");
        d();
        setMax(bundle.getInt("max"));
        setProgress(bundle.getInt("progress"));
        setPrefix(bundle.getString("prefix"));
        setSuffix(bundle.getString("suffix"));
        setProgressTextVisibility(bundle.getBoolean("text_visibility") ? ProgressTextVisibility.Visible : ProgressTextVisibility.Invisible);
        super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getProgressTextSize());
        bundle.putFloat("reached_bar_height", getReachedBarHeight());
        bundle.putFloat("unreached_bar_height", getUnreachedBarHeight());
        bundle.putInt("reached_bar_color", getReachedBarColor());
        bundle.putInt("unreached_bar_color", getUnreachedBarColor());
        bundle.putInt("max", getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffix());
        bundle.putString("prefix", getPrefix());
        bundle.putBoolean("text_visibility", getProgressTextVisibility());
        return bundle;
    }

    public void setMax(int i) {
        if (i > 0) {
            this.a = i;
            invalidate();
        }
    }

    public void setOnProgressBarListener(vv1 vv1Var) {
    }

    public void setPrefix(String str) {
        if (str == null) {
            this.j = Constants.STR_EMPTY;
        } else {
            this.j = str;
        }
    }

    public void setProgress(int i) {
        if (i > getMax()) {
            i = getMax();
        }
        if (i >= 0) {
            this.b = i;
            invalidate();
        }
    }

    public void setProgressTextColor(int i) {
        this.e = i;
        this.x.setColor(i);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.f = f;
        this.x.setTextSize(f);
        invalidate();
    }

    public void setProgressTextVisibility(ProgressTextVisibility progressTextVisibility) {
        this.I = progressTextVisibility == ProgressTextVisibility.Visible;
        invalidate();
    }

    public void setReachedBarColor(int i) {
        this.c = i;
        this.v.setColor(i);
        invalidate();
    }

    public void setReachedBarHeight(float f) {
        this.g = f;
    }

    public void setSuffix(String str) {
        if (str == null) {
            this.i = Constants.STR_EMPTY;
        } else {
            this.i = str;
        }
    }

    public void setUnreachedBarColor(int i) {
        this.d = i;
        this.w.setColor(i);
        invalidate();
    }

    public void setUnreachedBarHeight(float f) {
        this.h = f;
    }

    public NumberProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 100;
        this.b = 0;
        this.i = "%";
        this.j = Constants.STR_EMPTY;
        int iRgb = Color.rgb(66, Opcodes.I2B, Command.CMD_PHONE_NUMBER_PLAY_MODE);
        this.k = iRgb;
        int iRgb2 = Color.rgb(66, Opcodes.I2B, Command.CMD_PHONE_NUMBER_PLAY_MODE);
        this.l = iRgb2;
        int iRgb3 = Color.rgb(204, 204, 204);
        this.m = iRgb3;
        this.y = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.z = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        float fC = c(1.5f);
        this.p = fC;
        float fC2 = c(1.0f);
        this.f440q = fC2;
        float f = f(10.0f);
        this.o = f;
        float fC3 = c(3.0f);
        this.n = fC3;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.NumberProgressBar, i, 0);
        this.c = typedArrayObtainStyledAttributes.getColor(3, iRgb2);
        this.d = typedArrayObtainStyledAttributes.getColor(9, iRgb3);
        this.e = typedArrayObtainStyledAttributes.getColor(4, iRgb);
        this.f = typedArrayObtainStyledAttributes.getDimension(6, f);
        this.g = typedArrayObtainStyledAttributes.getDimension(2, fC);
        this.h = typedArrayObtainStyledAttributes.getDimension(8, fC2);
        this.F = typedArrayObtainStyledAttributes.getDimension(5, fC3);
        if (typedArrayObtainStyledAttributes.getInt(7, 0) != 0) {
            this.I = false;
        }
        setProgress(typedArrayObtainStyledAttributes.getInt(0, 0));
        setMax(typedArrayObtainStyledAttributes.getInt(1, 100));
        typedArrayObtainStyledAttributes.recycle();
        d();
    }
}
