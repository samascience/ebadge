package com.skydoves.colorpickerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;
import com.skydoves.colorpickerview.flag.FlagMode;
import com.skydoves.colorpickerview.flag.FlagView;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;
import defpackage.cb1;
import defpackage.db1;
import defpackage.gz;
import defpackage.hz;
import defpackage.kz;
import defpackage.lz;
import defpackage.q30;
import defpackage.v8;

/* JADX INFO: loaded from: classes.dex */
public class ColorPickerView extends FrameLayout implements cb1 {
    private int a;
    private int b;
    private Point c;
    private ImageView d;
    private ImageView e;
    private FlagView f;
    private Drawable g;
    private Drawable h;
    private AlphaSlideBar i;
    private BrightnessSlideBar j;
    private long k;
    private final Handler l;
    private ActionMode m;
    private float n;
    private float o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f309q;
    private String r;
    private final kz s;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ColorPickerView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ColorPickerView.this.p();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ColorPickerView colorPickerView = ColorPickerView.this;
            colorPickerView.f(colorPickerView.getColor(), true);
            ColorPickerView colorPickerView2 = ColorPickerView.this;
            colorPickerView2.m(colorPickerView2.c);
        }
    }

    class c implements Runnable {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ColorPickerView.this.r(this.a);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public ColorPickerView(Context context) {
        super(context);
        this.k = 0L;
        this.l = new Handler();
        this.m = ActionMode.ALWAYS;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = 0;
        this.f309q = false;
        this.s = kz.g(getContext());
    }

    private void g(AttributeSet attributeSet) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ColorPickerView);
        try {
            int i = R$styleable.ColorPickerView_palette;
            if (typedArrayObtainStyledAttributes.hasValue(i)) {
                this.g = typedArrayObtainStyledAttributes.getDrawable(i);
            }
            int i2 = R$styleable.ColorPickerView_selector;
            if (typedArrayObtainStyledAttributes.hasValue(i2) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i2, -1)) != -1) {
                this.h = v8.b(getContext(), resourceId);
            }
            int i3 = R$styleable.ColorPickerView_alpha_selector;
            if (typedArrayObtainStyledAttributes.hasValue(i3)) {
                this.n = typedArrayObtainStyledAttributes.getFloat(i3, this.n);
            }
            int i4 = R$styleable.ColorPickerView_selector_size;
            if (typedArrayObtainStyledAttributes.hasValue(i4)) {
                this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(i4, this.p);
            }
            int i5 = R$styleable.ColorPickerView_alpha_flag;
            if (typedArrayObtainStyledAttributes.hasValue(i5)) {
                this.o = typedArrayObtainStyledAttributes.getFloat(i5, this.o);
            }
            int i6 = R$styleable.ColorPickerView_actionMode;
            if (typedArrayObtainStyledAttributes.hasValue(i6)) {
                int integer = typedArrayObtainStyledAttributes.getInteger(i6, 0);
                if (integer == 0) {
                    this.m = ActionMode.ALWAYS;
                } else if (integer == 1) {
                    this.m = ActionMode.LAST;
                }
            }
            int i7 = R$styleable.ColorPickerView_debounceDuration;
            if (typedArrayObtainStyledAttributes.hasValue(i7)) {
                this.k = typedArrayObtainStyledAttributes.getInteger(i7, (int) this.k);
            }
            int i8 = R$styleable.ColorPickerView_preferenceName;
            if (typedArrayObtainStyledAttributes.hasValue(i8)) {
                this.r = typedArrayObtainStyledAttributes.getString(i8);
            }
            int i9 = R$styleable.ColorPickerView_initialColor;
            if (typedArrayObtainStyledAttributes.hasValue(i9)) {
                setInitialColor(typedArrayObtainStyledAttributes.getColor(i9, -1));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private Point h(int i, int i2) {
        return new Point(i - (this.e.getMeasuredWidth() / 2), i2 - (this.e.getMeasuredHeight() / 2));
    }

    private void l() {
        this.l.removeCallbacksAndMessages(null);
        this.l.postDelayed(new b(), this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Point point) {
        Point pointH = h(point.x, point.y);
        FlagView flagView = this.f;
        if (flagView != null) {
            if (flagView.getFlagMode() == FlagMode.ALWAYS) {
                this.f.f();
            }
            int width = (pointH.x - (this.f.getWidth() / 2)) + (this.e.getWidth() / 2);
            if (pointH.y - this.f.getHeight() > 0) {
                this.f.setRotation(0.0f);
                this.f.setX(width);
                FlagView flagView2 = this.f;
                flagView2.setY(pointH.y - flagView2.getHeight());
                this.f.d(getColorEnvelope());
            } else if (this.f.c()) {
                this.f.setRotation(180.0f);
                this.f.setX(width);
                FlagView flagView3 = this.f;
                flagView3.setY((pointH.y + flagView3.getHeight()) - (this.e.getHeight() * 0.5f));
                this.f.d(getColorEnvelope());
            }
            if (width < 0) {
                this.f.setX(0.0f);
            }
            if (width + this.f.getMeasuredWidth() > getMeasuredWidth()) {
                this.f.setX(getMeasuredWidth() - this.f.getMeasuredWidth());
            }
        }
    }

    private void n() {
        AlphaSlideBar alphaSlideBar = this.i;
        if (alphaSlideBar != null) {
            alphaSlideBar.e();
        }
        BrightnessSlideBar brightnessSlideBar = this.j;
        if (brightnessSlideBar != null) {
            brightnessSlideBar.e();
            if (this.j.a() != -1) {
                this.b = this.j.a();
                return;
            }
            AlphaSlideBar alphaSlideBar2 = this.i;
            if (alphaSlideBar2 != null) {
                this.b = alphaSlideBar2.a();
            }
        }
    }

    private void o() {
        setPadding(0, 0, 0, 0);
        ImageView imageView = new ImageView(getContext());
        this.d = imageView;
        Drawable drawable = this.g;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.d, layoutParams);
        ImageView imageView2 = new ImageView(getContext());
        this.e = imageView2;
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            imageView2.setImageDrawable(drawable2);
        } else {
            imageView2.setImageDrawable(q30.e(getContext(), R$drawable.wheel));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        if (this.p != 0) {
            layoutParams2.width = com.skydoves.colorpickerview.b.a(getContext(), this.p);
            layoutParams2.height = com.skydoves.colorpickerview.b.a(getContext(), this.p);
        }
        layoutParams2.gravity = 17;
        addView(this.e, layoutParams2);
        this.e.setAlpha(this.n);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
        if (getPreferenceName() != null) {
            this.s.k(this);
        } else {
            s();
        }
    }

    private boolean q(MotionEvent motionEvent) {
        Point pointC = com.skydoves.colorpickerview.a.c(this, new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
        int i = i(pointC.x, pointC.y);
        this.a = i;
        this.b = i;
        this.c = com.skydoves.colorpickerview.a.c(this, new Point(pointC.x, pointC.y));
        t(pointC.x, pointC.y);
        if (this.m != ActionMode.LAST || motionEvent.getAction() == 1) {
            l();
        }
        return true;
    }

    public void f(int i, boolean z) {
    }

    public ActionMode getActionMode() {
        return this.m;
    }

    @Override // android.view.View
    public float getAlpha() {
        return Color.alpha(getColor()) / 255.0f;
    }

    public AlphaSlideBar getAlphaSlideBar() {
        return this.i;
    }

    public BrightnessSlideBar getBrightnessSlider() {
        return this.j;
    }

    public int getColor() {
        return this.b;
    }

    public gz getColorEnvelope() {
        return new gz(getColor());
    }

    public long getDebounceDuration() {
        return this.k;
    }

    public FlagView getFlagView() {
        return this.f;
    }

    public String getPreferenceName() {
        return this.r;
    }

    public int getPureColor() {
        return this.a;
    }

    public Point getSelectedPoint() {
        return this.c;
    }

    public float getSelectorX() {
        return this.e.getX() - (this.e.getMeasuredWidth() * 0.5f);
    }

    public float getSelectorY() {
        return this.e.getY() - (this.e.getMeasuredHeight() * 0.5f);
    }

    protected int i(float f, float f2) {
        Matrix matrix = new Matrix();
        this.d.getImageMatrix().invert(matrix);
        float[] fArr = {f, f2};
        matrix.mapPoints(fArr);
        if (this.d.getDrawable() != null && (this.d.getDrawable() instanceof BitmapDrawable)) {
            float f3 = fArr[0];
            if (f3 >= 0.0f && fArr[1] >= 0.0f && f3 < this.d.getDrawable().getIntrinsicWidth() && fArr[1] < this.d.getDrawable().getIntrinsicHeight()) {
                invalidate();
                if (!(this.d.getDrawable() instanceof hz)) {
                    Rect bounds = this.d.getDrawable().getBounds();
                    return ((BitmapDrawable) this.d.getDrawable()).getBitmap().getPixel((int) ((fArr[0] / bounds.width()) * ((BitmapDrawable) this.d.getDrawable()).getBitmap().getWidth()), (int) ((fArr[1] / bounds.height()) * ((BitmapDrawable) this.d.getDrawable()).getBitmap().getHeight()));
                }
                float width = f - (getWidth() * 0.5f);
                float height = f2 - (getHeight() * 0.5f);
                double dSqrt = Math.sqrt((width * width) + (height * height));
                float fMin = Math.min(getWidth(), getHeight()) * 0.5f;
                float[] fArr2 = {0.0f, 0.0f, 1.0f};
                fArr2[0] = ((float) ((Math.atan2(height, -width) / 3.141592653589793d) * 180.0d)) + 180.0f;
                fArr2[1] = Math.max(0.0f, Math.min(1.0f, (float) (dSqrt / ((double) fMin))));
                return Color.HSVToColor(fArr2);
            }
        }
        return 0;
    }

    public boolean j() {
        return this.d.getDrawable() != null && (this.d.getDrawable() instanceof hz);
    }

    public void k(int i, int i2, int i3) {
        this.a = i3;
        this.b = i3;
        this.c = new Point(i, i2);
        t(i, i2);
        f(getColor(), false);
        m(this.c);
    }

    @j(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.s.l(this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.d.getDrawable() == null) {
            this.d.setImageDrawable(new hz(getResources(), Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888)));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1 && actionMasked != 2) {
            this.e.setPressed(false);
            return false;
        }
        if (getFlagView() != null) {
            getFlagView().e(motionEvent);
        }
        this.e.setPressed(true);
        return q(motionEvent);
    }

    public void r(int i) throws IllegalAccessException {
        if (!(this.d.getDrawable() instanceof hz)) {
            throw new IllegalAccessException("selectByHsvColor(@ColorInt int color) can be called only when the palette is an instance of ColorHsvPalette. Use setHsvPaletteDrawable();");
        }
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        float width = getWidth() * 0.5f;
        float height = getHeight() * 0.5f;
        float fMin = fArr[1] * Math.min(width, height);
        Point pointC = com.skydoves.colorpickerview.a.c(this, new Point((int) ((((double) fMin) * Math.cos(Math.toRadians(fArr[0]))) + ((double) width)), (int) ((((double) (-fMin)) * Math.sin(Math.toRadians(fArr[0]))) + ((double) height))));
        this.a = i;
        this.b = i;
        this.c = new Point(pointC.x, pointC.y);
        if (getAlphaSlideBar() != null) {
            getAlphaSlideBar().setSelectorPosition(getAlpha());
        }
        if (getBrightnessSlider() != null) {
            getBrightnessSlider().setSelectorPosition(fArr[2]);
        }
        t(pointC.x, pointC.y);
        f(getColor(), false);
        m(this.c);
    }

    public void s() {
        u(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
    }

    public void setActionMode(ActionMode actionMode) {
        this.m = actionMode;
    }

    public void setColorListener(lz lzVar) {
    }

    public void setDebounceDuration(long j) {
        this.k = j;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.e.setVisibility(z ? 0 : 4);
        if (getAlphaSlideBar() != null) {
            getAlphaSlideBar().setEnabled(z);
        }
        if (getBrightnessSlider() != null) {
            getBrightnessSlider().setEnabled(z);
        }
        if (z) {
            this.d.clearColorFilter();
        } else {
            this.d.setColorFilter(Color.argb(70, 255, 255, 255));
        }
    }

    public void setFlagView(FlagView flagView) {
        flagView.a();
        addView(flagView);
        this.f = flagView;
        flagView.setAlpha(this.o);
    }

    public void setInitialColor(int i) {
        if (getPreferenceName() == null || (getPreferenceName() != null && this.s.e(getPreferenceName(), -1) == -1)) {
            post(new c(i));
        }
    }

    public void setInitialColorRes(int i) {
        setInitialColor(q30.c(getContext(), i));
    }

    public void setLifecycleOwner(db1 db1Var) {
        db1Var.getLifecycle().a(this);
    }

    public void setPaletteDrawable(Drawable drawable) {
        removeView(this.d);
        ImageView imageView = new ImageView(getContext());
        this.d = imageView;
        this.g = drawable;
        imageView.setImageDrawable(drawable);
        addView(this.d);
        removeView(this.e);
        addView(this.e);
        this.a = -1;
        n();
        FlagView flagView = this.f;
        if (flagView != null) {
            removeView(flagView);
            addView(this.f);
        }
        if (this.f309q) {
            return;
        }
        this.f309q = true;
        ImageView imageView2 = this.e;
        if (imageView2 != null) {
            this.n = imageView2.getAlpha();
            this.e.setAlpha(0.0f);
        }
        FlagView flagView2 = this.f;
        if (flagView2 != null) {
            this.o = flagView2.getAlpha();
            this.f.setAlpha(0.0f);
        }
    }

    public void setPreferenceName(String str) {
        this.r = str;
        AlphaSlideBar alphaSlideBar = this.i;
        if (alphaSlideBar != null) {
            alphaSlideBar.setPreferenceName(str);
        }
        BrightnessSlideBar brightnessSlideBar = this.j;
        if (brightnessSlideBar != null) {
            brightnessSlideBar.setPreferenceName(str);
        }
    }

    public void setPureColor(int i) {
        this.a = i;
    }

    public void setSelectorDrawable(Drawable drawable) {
        this.e.setImageDrawable(drawable);
    }

    public void t(int i, int i2) {
        ImageView imageView = this.e;
        imageView.setX(i - (imageView.getMeasuredWidth() * 0.5f));
        ImageView imageView2 = this.e;
        imageView2.setY(i2 - (imageView2.getMeasuredHeight() * 0.5f));
    }

    public void u(int i, int i2) {
        Point pointC = com.skydoves.colorpickerview.a.c(this, new Point(i, i2));
        int i3 = i(pointC.x, pointC.y);
        this.a = i3;
        this.b = i3;
        this.c = new Point(pointC.x, pointC.y);
        t(pointC.x, pointC.y);
        f(getColor(), false);
        m(this.c);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0L;
        this.l = new Handler();
        this.m = ActionMode.ALWAYS;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = 0;
        this.f309q = false;
        this.s = kz.g(getContext());
        g(attributeSet);
        o();
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0L;
        this.l = new Handler();
        this.m = ActionMode.ALWAYS;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = 0;
        this.f309q = false;
        this.s = kz.g(getContext());
        g(attributeSet);
        o();
    }
}
