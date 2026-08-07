package q.rorbin.badgeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.connect.common.Constants;
import defpackage.ah1;
import defpackage.je;
import defpackage.ke;
import defpackage.mc0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QBadgeView extends View implements je {
    protected PointF F;
    protected PointF G;
    protected PointF H;
    protected PointF I;
    protected List J;
    protected View K;
    protected int L;
    protected int M;
    protected TextPaint N;
    protected Paint O;
    protected Paint P;
    protected ke Q;
    protected ViewGroup R;
    protected int a;
    protected int b;
    protected int c;
    protected Drawable d;
    protected Bitmap e;
    protected boolean f;
    protected float g;
    protected float h;
    protected float i;
    protected int j;
    protected String k;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    protected boolean o;
    protected int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected float f372q;
    protected float r;
    protected float s;
    protected float t;
    protected int u;
    protected boolean v;
    protected RectF w;
    protected RectF x;
    protected Path y;
    protected Paint.FontMetrics z;

    private class a extends ViewGroup {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
            if (getParent() instanceof RelativeLayout) {
                return;
            }
            super.dispatchRestoreInstanceState(sparseArray);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i, int i2) {
            View view = null;
            View view2 = null;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof QBadgeView) {
                    view2 = childAt;
                } else {
                    view = childAt;
                }
            }
            if (view == null) {
                super.onMeasure(i, i2);
                return;
            }
            view.measure(i, i2);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public QBadgeView(Context context) {
        this(context, null);
    }

    private void d() {
        if (this.k != null && this.f) {
            Bitmap bitmap = this.e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.e.recycle();
            }
            float badgeCircleRadius = getBadgeCircleRadius();
            if (!this.k.isEmpty() && this.k.length() != 1) {
                this.e = Bitmap.createBitmap((int) (this.w.width() + (this.i * 2.0f)), (int) (this.w.height() + this.i), Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(this.e);
                canvas.drawRoundRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), canvas.getHeight() / 2.0f, canvas.getHeight() / 2.0f, this.O);
            } else {
                int i = ((int) badgeCircleRadius) * 2;
                this.e = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_4444);
                Canvas canvas2 = new Canvas(this.e);
                canvas2.drawCircle(canvas2.getWidth() / 2.0f, canvas2.getHeight() / 2.0f, canvas2.getWidth() / 2.0f, this.O);
            }
        }
    }

    private void e(Canvas canvas, PointF pointF, float f) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (this.k.isEmpty() || this.k.length() == 1) {
            RectF rectF = this.x;
            float f2 = pointF.x;
            float f3 = (int) f;
            rectF.left = f2 - f3;
            float f4 = pointF.y;
            rectF.top = f4 - f3;
            rectF.right = f2 + f3;
            rectF.bottom = f3 + f4;
            if (this.d != null) {
                f(canvas);
            } else {
                canvas.drawCircle(f2, f4, f, this.O);
                if (this.b != 0 && this.g > 0.0f) {
                    canvas.drawCircle(pointF.x, pointF.y, f, this.P);
                }
            }
        } else {
            this.x.left = pointF.x - ((this.w.width() / 2.0f) + this.i);
            this.x.top = pointF.y - ((this.w.height() / 2.0f) + (this.i * 0.5f));
            this.x.right = pointF.x + (this.w.width() / 2.0f) + this.i;
            this.x.bottom = pointF.y + (this.w.height() / 2.0f) + (this.i * 0.5f);
            float fHeight = this.x.height() / 2.0f;
            if (this.d != null) {
                f(canvas);
            } else {
                canvas.drawRoundRect(this.x, fHeight, fHeight, this.O);
                if (this.b != 0 && this.g > 0.0f) {
                    canvas.drawRoundRect(this.x, fHeight, fHeight, this.P);
                }
            }
        }
        if (this.k.isEmpty()) {
            return;
        }
        String str = this.k;
        float f5 = pointF.x;
        RectF rectF2 = this.x;
        float f6 = rectF2.bottom + rectF2.top;
        Paint.FontMetrics fontMetrics = this.z;
        canvas.drawText(str, f5, ((f6 - fontMetrics.bottom) - fontMetrics.top) / 2.0f, this.N);
    }

    private void f(Canvas canvas) {
        this.O.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        RectF rectF = this.x;
        int i = (int) rectF.left;
        int i2 = (int) rectF.top;
        int width = (int) rectF.right;
        int height = (int) rectF.bottom;
        if (this.f) {
            width = i + this.e.getWidth();
            height = this.e.getHeight() + i2;
            canvas.saveLayer(i, i2, width, height, null, 31);
        }
        this.d.setBounds(i, i2, width, height);
        this.d.draw(canvas);
        if (!this.f) {
            canvas.drawRect(this.x, this.P);
            return;
        }
        this.O.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(this.e, i, i2, this.O);
        canvas.restore();
        this.O.setXfermode(null);
        if (this.k.isEmpty() || this.k.length() == 1) {
            canvas.drawCircle(this.x.centerX(), this.x.centerY(), this.x.width() / 2.0f, this.P);
        } else {
            RectF rectF2 = this.x;
            canvas.drawRoundRect(rectF2, rectF2.height() / 2.0f, this.x.height() / 2.0f, this.P);
        }
    }

    private void g(Canvas canvas, float f, float f2) {
        float f3;
        float f4;
        float f5;
        PointF pointF = this.G;
        float f6 = pointF.y;
        PointF pointF2 = this.H;
        float f7 = f6 - pointF2.y;
        float f8 = pointF.x - pointF2.x;
        this.J.clear();
        if (f8 != 0.0f) {
            double d = (-1.0d) / ((double) (f7 / f8));
            ah1.a(this.G, f2, Double.valueOf(d), this.J);
            ah1.a(this.H, f, Double.valueOf(d), this.J);
        } else {
            ah1.a(this.G, f2, Double.valueOf(0.0d), this.J);
            ah1.a(this.H, f, Double.valueOf(0.0d), this.J);
        }
        this.y.reset();
        Path path = this.y;
        PointF pointF3 = this.H;
        float f9 = pointF3.x;
        float f10 = pointF3.y;
        int i = this.u;
        path.addCircle(f9, f10, f, (i == 1 || i == 2) ? Path.Direction.CCW : Path.Direction.CW);
        PointF pointF4 = this.I;
        PointF pointF5 = this.H;
        float f11 = pointF5.x;
        PointF pointF6 = this.G;
        pointF4.x = (f11 + pointF6.x) / 2.0f;
        pointF4.y = (pointF5.y + pointF6.y) / 2.0f;
        this.y.moveTo(((PointF) this.J.get(2)).x, ((PointF) this.J.get(2)).y);
        Path path2 = this.y;
        PointF pointF7 = this.I;
        path2.quadTo(pointF7.x, pointF7.y, ((PointF) this.J.get(0)).x, ((PointF) this.J.get(0)).y);
        this.y.lineTo(((PointF) this.J.get(1)).x, ((PointF) this.J.get(1)).y);
        Path path3 = this.y;
        PointF pointF8 = this.I;
        path3.quadTo(pointF8.x, pointF8.y, ((PointF) this.J.get(3)).x, ((PointF) this.J.get(3)).y);
        this.y.lineTo(((PointF) this.J.get(2)).x, ((PointF) this.J.get(2)).y);
        this.y.close();
        canvas.drawPath(this.y, this.O);
        if (this.b == 0 || this.g <= 0.0f) {
            return;
        }
        this.y.reset();
        this.y.moveTo(((PointF) this.J.get(2)).x, ((PointF) this.J.get(2)).y);
        Path path4 = this.y;
        PointF pointF9 = this.I;
        path4.quadTo(pointF9.x, pointF9.y, ((PointF) this.J.get(0)).x, ((PointF) this.J.get(0)).y);
        this.y.moveTo(((PointF) this.J.get(1)).x, ((PointF) this.J.get(1)).y);
        Path path5 = this.y;
        PointF pointF10 = this.I;
        path5.quadTo(pointF10.x, pointF10.y, ((PointF) this.J.get(3)).x, ((PointF) this.J.get(3)).y);
        int i2 = this.u;
        if (i2 == 1 || i2 == 2) {
            float f12 = ((PointF) this.J.get(2)).x;
            PointF pointF11 = this.H;
            f3 = f12 - pointF11.x;
            f4 = pointF11.y;
            f5 = ((PointF) this.J.get(2)).y;
        } else {
            float f13 = ((PointF) this.J.get(3)).x;
            PointF pointF12 = this.H;
            f3 = f13 - pointF12.x;
            f4 = pointF12.y;
            f5 = ((PointF) this.J.get(3)).y;
        }
        double dAtan = Math.atan((f4 - f5) / f3);
        int i3 = this.u;
        float fE = 360.0f - ((float) ah1.e(ah1.d(dAtan, i3 + (-1) == 0 ? 4 : i3 - 1)));
        Path path6 = this.y;
        PointF pointF13 = this.H;
        float f14 = pointF13.x;
        float f15 = pointF13.y;
        path6.addArc(f14 - f, f15 - f, f14 + f, f15 + f, fE, 180.0f);
        canvas.drawPath(this.y, this.P);
    }

    private float getBadgeCircleRadius() {
        float fWidth;
        float f;
        if (this.k.isEmpty()) {
            return this.i;
        }
        if (this.k.length() != 1) {
            return this.x.height() / 2.0f;
        }
        if (this.w.height() > this.w.width()) {
            fWidth = this.w.height() / 2.0f;
            f = this.i;
        } else {
            fWidth = this.w.width() / 2.0f;
            f = this.i;
        }
        return fWidth + (f * 0.5f);
    }

    private void h(View view) {
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            h((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.R = (ViewGroup) view;
        }
    }

    private void i() {
        float fHeight = this.w.height() > this.w.width() ? this.w.height() : this.w.width();
        switch (this.p) {
            case 17:
                PointF pointF = this.F;
                pointF.x = this.L / 2.0f;
                pointF.y = this.M / 2.0f;
                break;
            case 49:
                PointF pointF2 = this.F;
                pointF2.x = this.L / 2.0f;
                pointF2.y = this.r + this.i + (this.w.height() / 2.0f);
                break;
            case 81:
                PointF pointF3 = this.F;
                pointF3.x = this.L / 2.0f;
                pointF3.y = this.M - ((this.r + this.i) + (this.w.height() / 2.0f));
                break;
            case 8388627:
                PointF pointF4 = this.F;
                pointF4.x = this.f372q + this.i + (fHeight / 2.0f);
                pointF4.y = this.M / 2.0f;
                break;
            case 8388629:
                PointF pointF5 = this.F;
                pointF5.x = this.L - ((this.f372q + this.i) + (fHeight / 2.0f));
                pointF5.y = this.M / 2.0f;
                break;
            case 8388659:
                PointF pointF6 = this.F;
                float f = this.f372q;
                float f2 = this.i;
                pointF6.x = f + f2 + (fHeight / 2.0f);
                pointF6.y = this.r + f2 + (this.w.height() / 2.0f);
                break;
            case 8388661:
                PointF pointF7 = this.F;
                float f3 = this.L;
                float f4 = this.f372q;
                float f5 = this.i;
                pointF7.x = f3 - ((f4 + f5) + (fHeight / 2.0f));
                pointF7.y = this.r + f5 + (this.w.height() / 2.0f);
                break;
            case 8388691:
                PointF pointF8 = this.F;
                float f6 = this.f372q;
                float f7 = this.i;
                pointF8.x = f6 + f7 + (fHeight / 2.0f);
                pointF8.y = this.M - ((this.r + f7) + (this.w.height() / 2.0f));
                break;
            case 8388693:
                PointF pointF9 = this.F;
                float f8 = this.L;
                float f9 = this.f372q;
                float f10 = this.i;
                pointF9.x = f8 - ((f9 + f10) + (fHeight / 2.0f));
                pointF9.y = this.M - ((this.r + f10) + (this.w.height() / 2.0f));
                break;
        }
        m();
    }

    private void j(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        this.R = viewGroup;
        if (viewGroup == null) {
            h(view);
        }
    }

    private void k() {
        setLayerType(1, null);
        this.w = new RectF();
        this.x = new RectF();
        this.y = new Path();
        this.F = new PointF();
        this.G = new PointF();
        this.H = new PointF();
        this.I = new PointF();
        this.J = new ArrayList();
        TextPaint textPaint = new TextPaint();
        this.N = textPaint;
        textPaint.setAntiAlias(true);
        this.N.setSubpixelText(true);
        this.N.setFakeBoldText(true);
        this.N.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint = new Paint();
        this.O = paint;
        paint.setAntiAlias(true);
        this.O.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.P = paint2;
        paint2.setAntiAlias(true);
        this.P.setStyle(Paint.Style.STROKE);
        this.a = -1552832;
        this.c = -1;
        this.h = mc0.a(getContext(), 11.0f);
        this.i = mc0.a(getContext(), 5.0f);
        this.j = 0;
        this.p = 8388661;
        this.f372q = mc0.a(getContext(), 1.0f);
        this.r = mc0.a(getContext(), 1.0f);
        this.t = mc0.a(getContext(), 90.0f);
        this.o = true;
        this.f = false;
        setTranslationZ(1000.0f);
    }

    private void l() {
        s(this.o);
        this.O.setColor(this.a);
        this.P.setColor(this.b);
        this.P.setStrokeWidth(this.g);
        this.N.setColor(this.c);
        this.N.setTextAlign(Paint.Align.CENTER);
    }

    private void m() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        PointF pointF = this.H;
        PointF pointF2 = this.F;
        pointF.x = pointF2.x + iArr[0];
        pointF.y = pointF2.y + iArr[1];
    }

    private void n() {
        RectF rectF = this.w;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        if (TextUtils.isEmpty(this.k)) {
            RectF rectF2 = this.w;
            rectF2.right = 0.0f;
            rectF2.bottom = 0.0f;
        } else {
            this.N.setTextSize(this.h);
            this.w.right = this.N.measureText(this.k);
            Paint.FontMetrics fontMetrics = this.N.getFontMetrics();
            this.z = fontMetrics;
            this.w.bottom = fontMetrics.descent - fontMetrics.ascent;
        }
        d();
    }

    private void o() {
        if (this.v) {
            a(this.G);
            t(5);
        } else {
            p();
            t(4);
        }
    }

    private void s(boolean z) {
        int iA = mc0.a(getContext(), 1.0f);
        int iA2 = mc0.a(getContext(), 1.5f);
        int i = this.u;
        if (i == 1) {
            iA = mc0.a(getContext(), 1.0f);
            iA2 = mc0.a(getContext(), -1.5f);
        } else if (i == 2) {
            iA = mc0.a(getContext(), -1.0f);
            iA2 = mc0.a(getContext(), -1.5f);
        } else if (i == 3) {
            iA = mc0.a(getContext(), -1.0f);
            iA2 = mc0.a(getContext(), 1.5f);
        } else if (i == 4) {
            iA = mc0.a(getContext(), 1.0f);
            iA2 = mc0.a(getContext(), 1.5f);
        }
        this.O.setShadowLayer(z ? mc0.a(getContext(), 2.0f) : 0.0f, iA, iA2, 855638016);
    }

    private void t(int i) {
    }

    protected void a(PointF pointF) {
        if (this.k == null) {
            return;
        }
        ke keVar = this.Q;
        if (keVar == null || !keVar.isRunning()) {
            q(true);
            ke keVar2 = new ke(c(), pointF, this);
            this.Q = keVar2;
            keVar2.start();
            r(0);
        }
    }

    public je b(View view) {
        if (view == null) {
            throw new IllegalStateException("targetView can not be null");
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("targetView must have a parent");
        }
        this.K = view;
        if (parent instanceof a) {
            ((a) parent).addView(this);
        } else {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            viewGroup.removeView(view);
            a aVar = new a(getContext());
            if (viewGroup instanceof RelativeLayout) {
                aVar.setId(view.getId());
            }
            viewGroup.addView(aVar, iIndexOfChild, layoutParams);
            aVar.addView(view);
            aVar.addView(this);
        }
        return this;
    }

    protected Bitmap c() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.x.width()) + mc0.a(getContext(), 3.0f), ((int) this.x.height()) + mc0.a(getContext(), 3.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        e(canvas, new PointF(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f), getBadgeCircleRadius());
        return bitmapCreateBitmap;
    }

    public Drawable getBadgeBackground() {
        return this.d;
    }

    public int getBadgeBackgroundColor() {
        return this.a;
    }

    public int getBadgeGravity() {
        return this.p;
    }

    public int getBadgeNumber() {
        return this.j;
    }

    public String getBadgeText() {
        return this.k;
    }

    public int getBadgeTextColor() {
        return this.c;
    }

    public PointF getDragCenter() {
        if (this.l && this.m) {
            return this.G;
        }
        return null;
    }

    public View getTargetView() {
        return this.K;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.R == null) {
            j(this.K);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ke keVar = this.Q;
        if (keVar != null && keVar.isRunning()) {
            this.Q.b(canvas);
            return;
        }
        if (this.k != null) {
            l();
            float badgeCircleRadius = getBadgeCircleRadius();
            float fB = this.s * (1.0f - (ah1.b(this.H, this.G) / this.t));
            if (!this.l || !this.m) {
                i();
                e(canvas, this.F, badgeCircleRadius);
                return;
            }
            this.u = ah1.c(this.G, this.H);
            s(this.o);
            boolean z = fB < ((float) mc0.a(getContext(), 1.5f));
            this.v = z;
            if (z) {
                t(3);
                e(canvas, this.G, badgeCircleRadius);
            } else {
                t(2);
                g(canvas, fB, badgeCircleRadius);
                e(canvas, this.G, badgeCircleRadius);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.L = i;
        this.M = i2;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0031  */
    /* JADX WARN: Code duplicated, block: B:19:0x003b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x;
        RectF rectF;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.l && motionEvent.getPointerId(motionEvent.getActionIndex()) == 0) {
                rectF = this.x;
                if (x > rectF.left && x < rectF.right && y > rectF.top && y < rectF.bottom && this.k != null) {
                    m();
                    this.m = true;
                    t(1);
                    this.s = mc0.a(getContext(), 7.0f);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    q(true);
                    this.G.x = motionEvent.getRawX();
                    this.G.y = motionEvent.getRawY();
                }
            }
        } else if (actionMasked == 1) {
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 0 && this.m) {
                this.m = false;
                o();
            }
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 0) {
                    this.m = false;
                    o();
                }
            } else if (actionMasked == 5) {
                x = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (this.l) {
                    rectF = this.x;
                    if (x > rectF.left) {
                        m();
                        this.m = true;
                        t(1);
                        this.s = mc0.a(getContext(), 7.0f);
                        getParent().requestDisallowInterceptTouchEvent(true);
                        q(true);
                        this.G.x = motionEvent.getRawX();
                        this.G.y = motionEvent.getRawY();
                    }
                }
            } else if (actionMasked == 6) {
                if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 0) {
                    this.m = false;
                    o();
                }
            }
        } else if (this.m) {
            this.G.x = motionEvent.getRawX();
            this.G.y = motionEvent.getRawY();
            invalidate();
        }
        return this.m || super.onTouchEvent(motionEvent);
    }

    public void p() {
        PointF pointF = this.G;
        pointF.x = -1000.0f;
        pointF.y = -1000.0f;
        this.u = 4;
        q(false);
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
    }

    protected void q(boolean z) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (z) {
            this.R.addView(this, new FrameLayout.LayoutParams(-1, -1));
        } else {
            b(this.K);
        }
    }

    public je r(int i) {
        this.j = i;
        if (i < 0) {
            this.k = Constants.STR_EMPTY;
        } else if (i > 99) {
            this.k = this.n ? String.valueOf(i) : "99+";
        } else if (i > 0 && i <= 99) {
            this.k = String.valueOf(i);
        } else if (i == 0) {
            this.k = null;
        }
        n();
        invalidate();
        return this;
    }

    private QBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private QBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k();
    }
}
