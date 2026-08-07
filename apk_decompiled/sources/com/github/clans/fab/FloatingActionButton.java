package com.github.clans.fab;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends ImageButton {
    private static final Xfermode d0 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private boolean F;
    private RectF G;
    private Paint H;
    private Paint I;
    private boolean J;
    private long K;
    private float L;
    private long M;
    private double N;
    private boolean O;
    private int P;
    private float Q;
    private float R;
    private float S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;
    int a;
    private int a0;
    boolean b;
    private boolean b0;
    int c;
    GestureDetector c0;
    int d;
    int e;
    int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private int l;
    private Animation m;
    private Animation n;
    private String o;
    private View.OnClickListener p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f231q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private float y;
    private float z;

    static class ProgressSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<ProgressSavedState> CREATOR = new a();
        float a;
        float b;
        float c;
        int d;
        int e;
        int f;
        int g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;
        boolean n;

        static class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ProgressSavedState createFromParcel(Parcel parcel) {
                return new ProgressSavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ProgressSavedState[] newArray(int i) {
                return new ProgressSavedState[i];
            }
        }

        /* synthetic */ ProgressSavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.a);
            parcel.writeFloat(this.b);
            parcel.writeInt(this.h ? 1 : 0);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeInt(this.l ? 1 : 0);
            parcel.writeInt(this.m ? 1 : 0);
            parcel.writeInt(this.n ? 1 : 0);
        }

        ProgressSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private ProgressSavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readFloat();
            this.b = parcel.readFloat();
            this.h = parcel.readInt() != 0;
            this.c = parcel.readFloat();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
            this.i = parcel.readInt() != 0;
            this.j = parcel.readInt() != 0;
            this.k = parcel.readInt() != 0;
            this.l = parcel.readInt() != 0;
            this.m = parcel.readInt() != 0;
            this.n = parcel.readInt() != 0;
        }
    }

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setOval(0, 0, view.getWidth(), view.getHeight());
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            Label label = (Label) FloatingActionButton.this.getTag(R$id.fab_label);
            if (label != null) {
                label.s();
            }
            FloatingActionButton.this.z();
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Label label = (Label) FloatingActionButton.this.getTag(R$id.fab_label);
            if (label != null) {
                label.t();
            }
            FloatingActionButton.this.A();
            return super.onSingleTapUp(motionEvent);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (FloatingActionButton.this.p != null) {
                FloatingActionButton.this.p.onClick(FloatingActionButton.this);
            }
        }
    }

    private class d extends ShapeDrawable {
        private int a;
        private int b;

        /* synthetic */ d(FloatingActionButton floatingActionButton, Shape shape, a aVar) {
            this(shape);
        }

        @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            setBounds(this.a, this.b, FloatingActionButton.this.o() - this.a, FloatingActionButton.this.n() - this.b);
            super.draw(canvas);
        }

        private d(Shape shape) {
            super(shape);
            this.a = FloatingActionButton.this.t() ? FloatingActionButton.this.d + Math.abs(FloatingActionButton.this.e) : 0;
            this.b = FloatingActionButton.this.t() ? Math.abs(FloatingActionButton.this.f) + FloatingActionButton.this.d : 0;
            if (FloatingActionButton.this.t) {
                this.a += FloatingActionButton.this.u;
                this.b += FloatingActionButton.this.u;
            }
        }
    }

    private class e extends Drawable {
        private Paint a;
        private Paint b;
        private float c;

        /* synthetic */ e(FloatingActionButton floatingActionButton, a aVar) {
            this();
        }

        private void a() {
            FloatingActionButton.this.setLayerType(1, null);
            this.a.setStyle(Paint.Style.FILL);
            this.a.setColor(FloatingActionButton.this.g);
            this.b.setXfermode(FloatingActionButton.d0);
            if (!FloatingActionButton.this.isInEditMode()) {
                Paint paint = this.a;
                FloatingActionButton floatingActionButton = FloatingActionButton.this;
                paint.setShadowLayer(floatingActionButton.d, floatingActionButton.e, floatingActionButton.f, floatingActionButton.c);
            }
            this.c = FloatingActionButton.this.getCircleSize() / 2;
            if (FloatingActionButton.this.t && FloatingActionButton.this.b0) {
                this.c += FloatingActionButton.this.u;
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawCircle(FloatingActionButton.this.l(), FloatingActionButton.this.m(), this.c, this.a);
            canvas.drawCircle(FloatingActionButton.this.l(), FloatingActionButton.this.m(), this.c, this.b);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        private e() {
            this.a = new Paint(1);
            this.b = new Paint(1);
            a();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private void D() {
        if (this.F) {
            return;
        }
        if (this.y == -1.0f) {
            this.y = getX();
        }
        if (this.z == -1.0f) {
            this.z = getY();
        }
        this.F = true;
    }

    private void G() {
        this.H.setColor(this.w);
        Paint paint = this.H;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.H.setStrokeWidth(this.u);
        this.I.setColor(this.v);
        this.I.setStyle(style);
        this.I.setStrokeWidth(this.u);
    }

    private void H() {
        int shadowX = t() ? getShadowX() : 0;
        int shadowY = t() ? getShadowY() : 0;
        int i = this.u;
        this.G = new RectF((i / 2) + shadowX, (i / 2) + shadowY, (o() - shadowX) - (this.u / 2), (n() - shadowY) - (this.u / 2));
    }

    private void K() {
        float x;
        float y;
        if (this.t) {
            x = this.y > getX() ? getX() + this.u : getX() - this.u;
            y = this.z > getY() ? getY() + this.u : getY() - this.u;
        } else {
            x = this.y;
            y = this.z;
        }
        setX(x);
        setY(y);
    }

    private void L(long j) {
        long j2 = this.M;
        if (j2 < 200) {
            this.M = j2 + j;
            return;
        }
        double d2 = this.N + j;
        this.N = d2;
        if (d2 > 500.0d) {
            this.N = d2 - 500.0d;
            this.M = 0L;
            this.O = !this.O;
        }
        float fCos = (((float) Math.cos(((this.N / 500.0d) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
        float f = 270 - this.P;
        if (this.O) {
            this.Q = fCos * f;
            return;
        }
        float f2 = f * (1.0f - fCos);
        this.R += this.Q - f2;
        this.Q = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCircleSize() {
        return getResources().getDimensionPixelSize(this.a == 0 ? R$dimen.fab_size_normal : R$dimen.fab_size_mini);
    }

    private int getShadowX() {
        return this.d + Math.abs(this.e);
    }

    private int getShadowY() {
        return this.d + Math.abs(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float l() {
        return getMeasuredWidth() / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float m() {
        return getMeasuredHeight() / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        int circleSize = getCircleSize() + p();
        return this.t ? circleSize + (this.u * 2) : circleSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o() {
        int circleSize = getCircleSize() + q();
        return this.t ? circleSize + (this.u * 2) : circleSize;
    }

    private Drawable r(int i) {
        d dVar = new d(this, new OvalShape(), null);
        dVar.getPaint().setColor(i);
        return dVar;
    }

    private Drawable s() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842910}, r(this.i));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, r(this.h));
        stateListDrawable.addState(new int[0], r(this.g));
        if (!com.github.clans.fab.a.c()) {
            this.f231q = stateListDrawable;
            return stateListDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.j}), stateListDrawable, null);
        setOutlineProvider(new a());
        setClipToOutline(true);
        this.f231q = rippleDrawable;
        return rippleDrawable;
    }

    @TargetApi(16)
    private void setBackgroundCompat(Drawable drawable) {
        if (com.github.clans.fab.a.b()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private void v(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton, i, 0);
        this.g = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionButton_fab_colorNormal, -2473162);
        this.h = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionButton_fab_colorPressed, -1617853);
        this.i = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionButton_fab_colorDisabled, -5592406);
        this.j = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionButton_fab_colorRipple, -1711276033);
        this.b = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_fab_showShadow, true);
        this.c = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionButton_fab_shadowColor, 1711276032);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_fab_shadowRadius, this.d);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_fab_shadowXOffset, this.e);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.FloatingActionButton_fab_shadowYOffset, this.f);
        this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionButton_fab_size, 0);
        this.o = typedArrayObtainStyledAttributes.getString(R$styleable.FloatingActionButton_fab_label);
        this.V = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_fab_progress_indeterminate, false);
        this.v = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionButton_fab_progress_color, -16738680);
        this.w = typedArrayObtainStyledAttributes.getColor(R$styleable.FloatingActionButton_fab_progress_backgroundColor, 1291845632);
        this.a0 = typedArrayObtainStyledAttributes.getInt(R$styleable.FloatingActionButton_fab_progress_max, this.a0);
        this.b0 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_fab_progress_showBackground, true);
        int i2 = R$styleable.FloatingActionButton_fab_progress;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            this.T = typedArrayObtainStyledAttributes.getInt(i2, 0);
            this.W = true;
        }
        int i3 = R$styleable.FloatingActionButton_fab_elevationCompat;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i3, 0);
            if (isInEditMode()) {
                setElevation(dimensionPixelOffset);
            } else {
                setElevationCompat(dimensionPixelOffset);
            }
        }
        x(typedArrayObtainStyledAttributes);
        w(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        if (isInEditMode()) {
            if (this.V) {
                setIndeterminate(true);
            } else if (this.W) {
                D();
                F(this.T, false);
            }
        }
        setClickable(true);
    }

    private void w(TypedArray typedArray) {
        this.n = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(R$styleable.FloatingActionButton_fab_hideAnimation, R$anim.fab_scale_down));
    }

    private void x(TypedArray typedArray) {
        this.m = AnimationUtils.loadAnimation(getContext(), typedArray.getResourceId(R$styleable.FloatingActionButton_fab_showAnimation, R$anim.fab_scale_up));
    }

    void A() {
        Drawable drawable = this.f231q;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{R.attr.state_enabled});
        } else if (com.github.clans.fab.a.c()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.f231q;
            rippleDrawable.setState(new int[]{R.attr.state_enabled});
            rippleDrawable.setHotspot(l(), m());
            rippleDrawable.setVisible(true, true);
        }
    }

    void B() {
        this.m.cancel();
        startAnimation(this.n);
    }

    void C() {
        this.n.cancel();
        startAnimation(this.m);
    }

    void E(int i, int i2, int i3) {
        this.g = i;
        this.h = i2;
        this.j = i3;
    }

    public synchronized void F(int i, boolean z) {
        if (this.J) {
            return;
        }
        this.T = i;
        this.U = z;
        if (!this.F) {
            this.W = true;
            return;
        }
        this.t = true;
        this.x = true;
        H();
        D();
        J();
        if (i < 0) {
            i = 0;
        } else {
            int i2 = this.a0;
            if (i > i2) {
                i = i2;
            }
        }
        float f = i;
        if (f == this.S) {
            return;
        }
        int i3 = this.a0;
        this.S = i3 > 0 ? (f / i3) * 360.0f : 0.0f;
        this.K = SystemClock.uptimeMillis();
        if (!z) {
            this.R = this.S;
        }
        invalidate();
    }

    public void I(boolean z) {
        if (y()) {
            if (z) {
                C();
            }
            super.setVisibility(0);
        }
    }

    void J() {
        LayerDrawable layerDrawable = t() ? new LayerDrawable(new Drawable[]{new e(this, null), s(), getIconDrawable()}) : new LayerDrawable(new Drawable[]{s(), getIconDrawable()});
        int iMax = getIconDrawable() != null ? Math.max(getIconDrawable().getIntrinsicWidth(), getIconDrawable().getIntrinsicHeight()) : -1;
        int circleSize = getCircleSize();
        if (iMax <= 0) {
            iMax = this.l;
        }
        int i = (circleSize - iMax) / 2;
        int iAbs = t() ? this.d + Math.abs(this.e) : 0;
        int iAbs2 = t() ? this.d + Math.abs(this.f) : 0;
        if (this.t) {
            int i2 = this.u;
            iAbs += i2;
            iAbs2 += i2;
        }
        int i3 = iAbs + i;
        int i4 = iAbs2 + i;
        layerDrawable.setLayerInset(t() ? 2 : 1, i3, i4, i3, i4);
        setBackgroundCompat(layerDrawable);
    }

    public int getButtonSize() {
        return this.a;
    }

    public int getColorDisabled() {
        return this.i;
    }

    public int getColorNormal() {
        return this.g;
    }

    public int getColorPressed() {
        return this.h;
    }

    public int getColorRipple() {
        return this.j;
    }

    Animation getHideAnimation() {
        return this.n;
    }

    protected Drawable getIconDrawable() {
        Drawable drawable = this.k;
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    public String getLabelText() {
        return this.o;
    }

    Label getLabelView() {
        return (Label) getTag(R$id.fab_label);
    }

    public int getLabelVisibility() {
        Label labelView = getLabelView();
        if (labelView != null) {
            return labelView.getVisibility();
        }
        return -1;
    }

    public synchronized int getMax() {
        return this.a0;
    }

    View.OnClickListener getOnClickListener() {
        return this.p;
    }

    public synchronized int getProgress() {
        return this.J ? 0 : this.T;
    }

    public int getShadowColor() {
        return this.c;
    }

    public int getShadowRadius() {
        return this.d;
    }

    public int getShadowXOffset() {
        return this.e;
    }

    public int getShadowYOffset() {
        return this.f;
    }

    Animation getShowAnimation() {
        return this.m;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.t) {
            if (this.b0) {
                canvas.drawArc(this.G, 360.0f, 360.0f, false, this.H);
            }
            boolean z = true;
            if (this.J) {
                long jUptimeMillis = SystemClock.uptimeMillis() - this.K;
                float f = (jUptimeMillis * this.L) / 1000.0f;
                L(jUptimeMillis);
                float f2 = this.R + f;
                this.R = f2;
                if (f2 > 360.0f) {
                    this.R = f2 - 360.0f;
                }
                this.K = SystemClock.uptimeMillis();
                float f3 = this.R - 90.0f;
                float f4 = this.P + this.Q;
                if (isInEditMode()) {
                    f3 = 0.0f;
                    f4 = 135.0f;
                }
                canvas.drawArc(this.G, f3, f4, false, this.I);
            } else {
                if (this.R != this.S) {
                    float fUptimeMillis = ((SystemClock.uptimeMillis() - this.K) / 1000.0f) * this.L;
                    float f5 = this.R;
                    float f6 = this.S;
                    if (f5 > f6) {
                        this.R = Math.max(f5 - fUptimeMillis, f6);
                    } else {
                        this.R = Math.min(f5 + fUptimeMillis, f6);
                    }
                    this.K = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                canvas.drawArc(this.G, -90.0f, this.R, false, this.I);
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(o(), n());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ProgressSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ProgressSavedState progressSavedState = (ProgressSavedState) parcelable;
        super.onRestoreInstanceState(progressSavedState.getSuperState());
        this.R = progressSavedState.a;
        this.S = progressSavedState.b;
        this.L = progressSavedState.c;
        this.u = progressSavedState.e;
        this.v = progressSavedState.f;
        this.w = progressSavedState.g;
        this.V = progressSavedState.k;
        this.W = progressSavedState.l;
        this.T = progressSavedState.d;
        this.U = progressSavedState.m;
        this.b0 = progressSavedState.n;
        this.K = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ProgressSavedState progressSavedState = new ProgressSavedState(super.onSaveInstanceState());
        progressSavedState.a = this.R;
        progressSavedState.b = this.S;
        progressSavedState.c = this.L;
        progressSavedState.e = this.u;
        progressSavedState.f = this.v;
        progressSavedState.g = this.w;
        boolean z = this.J;
        progressSavedState.k = z;
        progressSavedState.l = this.t && this.T > 0 && !z;
        progressSavedState.d = this.T;
        progressSavedState.m = this.U;
        progressSavedState.n = this.b0;
        return progressSavedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        D();
        if (this.V) {
            setIndeterminate(true);
            this.V = false;
        } else if (this.W) {
            F(this.T, this.U);
            this.W = false;
        } else if (this.x) {
            K();
            this.x = false;
        }
        super.onSizeChanged(i, i2, i3, i4);
        H();
        G();
        J();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.p != null && isEnabled()) {
            Label label = (Label) getTag(R$id.fab_label);
            if (label == null) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 1 || action == 3) {
                label.t();
                A();
            }
            this.c0.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    int p() {
        if (t()) {
            return getShadowY() * 2;
        }
        return 0;
    }

    int q() {
        if (t()) {
            return getShadowX() * 2;
        }
        return 0;
    }

    public void setButtonSize(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Use @FabSize constants only!");
        }
        if (this.a != i) {
            this.a = i;
            J();
        }
    }

    public void setColorDisabled(int i) {
        if (i != this.i) {
            this.i = i;
            J();
        }
    }

    public void setColorDisabledResId(int i) {
        setColorDisabled(getResources().getColor(i));
    }

    public void setColorNormal(int i) {
        if (this.g != i) {
            this.g = i;
            J();
        }
    }

    public void setColorNormalResId(int i) {
        setColorNormal(getResources().getColor(i));
    }

    public void setColorPressed(int i) {
        if (i != this.h) {
            this.h = i;
            J();
        }
    }

    public void setColorPressedResId(int i) {
        setColorPressed(getResources().getColor(i));
    }

    public void setColorRipple(int i) {
        if (i != this.j) {
            this.j = i;
            J();
        }
    }

    public void setColorRippleResId(int i) {
        setColorRipple(getResources().getColor(i));
    }

    @Override // android.view.View
    public void setElevation(float f) {
        if (!com.github.clans.fab.a.c() || f <= 0.0f) {
            return;
        }
        super.setElevation(f);
        if (!isInEditMode()) {
            this.r = true;
            this.b = false;
        }
        J();
    }

    @TargetApi(21)
    public void setElevationCompat(float f) {
        this.c = 637534208;
        float f2 = f / 2.0f;
        this.d = Math.round(f2);
        this.e = 0;
        if (this.a == 0) {
            f2 = f;
        }
        this.f = Math.round(f2);
        if (!com.github.clans.fab.a.c()) {
            this.b = true;
            J();
            return;
        }
        super.setElevation(f);
        this.s = true;
        this.b = false;
        J();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        Label label = (Label) getTag(R$id.fab_label);
        if (label != null) {
            label.setEnabled(z);
        }
    }

    public void setHideAnimation(Animation animation) {
        this.n = animation;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.k != drawable) {
            this.k = drawable;
            J();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        Drawable drawable = getResources().getDrawable(i);
        if (this.k != drawable) {
            this.k = drawable;
            J();
        }
    }

    public synchronized void setIndeterminate(boolean z) {
        if (!z) {
            try {
                this.R = 0.0f;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.t = z;
        this.x = true;
        this.J = z;
        this.K = SystemClock.uptimeMillis();
        H();
        J();
    }

    public void setLabelText(String str) {
        this.o = str;
        Label labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(str);
        }
    }

    public void setLabelTextColor(int i) {
        getLabelView().setTextColor(i);
    }

    public void setLabelVisibility(int i) {
        Label labelView = getLabelView();
        if (labelView != null) {
            labelView.setVisibility(i);
            labelView.setHandleVisibilityChanges(i == 0);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && this.s) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin += getShadowX();
            marginLayoutParams.topMargin += getShadowY();
            marginLayoutParams.rightMargin += getShadowX();
            marginLayoutParams.bottomMargin += getShadowY();
        }
        super.setLayoutParams(layoutParams);
    }

    public synchronized void setMax(int i) {
        this.a0 = i;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.p = onClickListener;
        View view = (View) getTag(R$id.fab_label);
        if (view != null) {
            view.setOnClickListener(new c());
        }
    }

    public void setShadowColor(int i) {
        if (this.c != i) {
            this.c = i;
            J();
        }
    }

    public void setShadowColorResource(int i) {
        int color = getResources().getColor(i);
        if (this.c != color) {
            this.c = color;
            J();
        }
    }

    public void setShadowRadius(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.d != dimensionPixelSize) {
            this.d = dimensionPixelSize;
            requestLayout();
            J();
        }
    }

    public void setShadowXOffset(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.e != dimensionPixelSize) {
            this.e = dimensionPixelSize;
            requestLayout();
            J();
        }
    }

    public void setShadowYOffset(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        if (this.f != dimensionPixelSize) {
            this.f = dimensionPixelSize;
            requestLayout();
            J();
        }
    }

    public void setShowAnimation(Animation animation) {
        this.m = animation;
    }

    public synchronized void setShowProgressBackground(boolean z) {
        this.b0 = z;
    }

    public void setShowShadow(boolean z) {
        if (this.b != z) {
            this.b = z;
            J();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        Label label = (Label) getTag(R$id.fab_label);
        if (label != null) {
            label.setVisibility(i);
        }
    }

    public boolean t() {
        return !this.r && this.b;
    }

    public void u(boolean z) {
        if (y()) {
            return;
        }
        if (z) {
            B();
        }
        super.setVisibility(4);
    }

    public boolean y() {
        return getVisibility() == 4;
    }

    void z() {
        Drawable drawable = this.f231q;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{R.attr.state_enabled, R.attr.state_pressed});
        } else if (com.github.clans.fab.a.c()) {
            RippleDrawable rippleDrawable = (RippleDrawable) this.f231q;
            rippleDrawable.setState(new int[]{R.attr.state_enabled, R.attr.state_pressed});
            rippleDrawable.setHotspot(l(), m());
            rippleDrawable.setVisible(true, true);
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setLabelTextColor(ColorStateList colorStateList) {
        getLabelView().setTextColor(colorStateList);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = com.github.clans.fab.a.a(getContext(), 4.0f);
        this.e = com.github.clans.fab.a.a(getContext(), 1.0f);
        this.f = com.github.clans.fab.a.a(getContext(), 3.0f);
        this.l = com.github.clans.fab.a.a(getContext(), 24.0f);
        this.u = com.github.clans.fab.a.a(getContext(), 6.0f);
        this.y = -1.0f;
        this.z = -1.0f;
        this.G = new RectF();
        this.H = new Paint(1);
        this.I = new Paint(1);
        this.L = 195.0f;
        this.M = 0L;
        this.O = true;
        this.P = 16;
        this.a0 = 100;
        this.c0 = new GestureDetector(getContext(), new b());
        v(context, attributeSet, i);
    }

    public void setShadowRadius(float f) {
        this.d = com.github.clans.fab.a.a(getContext(), f);
        requestLayout();
        J();
    }

    public void setShadowXOffset(float f) {
        this.e = com.github.clans.fab.a.a(getContext(), f);
        requestLayout();
        J();
    }

    public void setShadowYOffset(float f) {
        this.f = com.github.clans.fab.a.a(getContext(), f);
        requestLayout();
        J();
    }
}
