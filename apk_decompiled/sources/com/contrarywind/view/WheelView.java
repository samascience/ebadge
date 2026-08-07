package com.contrarywind.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.connect.common.Constants;
import defpackage.c21;
import defpackage.ee1;
import defpackage.ei3;
import defpackage.gj1;
import defpackage.kv1;
import defpackage.sr2;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class WheelView extends View {
    private static final String[] b0 = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};
    private float F;
    private float G;
    private float H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private float Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private int V;
    private float W;
    private DividerType a;
    private boolean a0;
    private Context b;
    private Handler c;
    private GestureDetector d;
    private boolean e;
    private boolean f;
    private ScheduledExecutorService g;
    private ScheduledFuture h;
    private Paint i;
    private Paint j;
    private Paint k;
    private ei3 l;
    private String m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f229q;
    private float r;
    private Typeface s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float x;
    private boolean y;
    private float z;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum DividerType {
        FILL,
        WRAP,
        CIRCLE
    }

    public WheelView(Context context) {
        this(context, null);
    }

    private String b(Object obj) {
        if (obj == null) {
            return Constants.STR_EMPTY;
        }
        return obj instanceof Integer ? c(((Integer) obj).intValue()) : obj.toString();
    }

    private String c(int i) {
        return (i < 0 || i >= 10) ? String.valueOf(i) : b0[i];
    }

    private int d(int i) {
        if (i < 0) {
            return d(i + this.l.a());
        }
        return i > this.l.a() + (-1) ? d(i - this.l.a()) : i;
    }

    private void f(Context context) {
        this.b = context;
        this.c = new gj1(this);
        GestureDetector gestureDetector = new GestureDetector(context, new ee1(this));
        this.d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.y = true;
        this.H = 0.0f;
        this.I = -1;
        g();
    }

    private void g() {
        Paint paint = new Paint();
        this.i = paint;
        paint.setColor(this.t);
        this.i.setAntiAlias(true);
        this.i.setTypeface(this.s);
        this.i.setTextSize(this.n);
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.setColor(this.u);
        this.j.setAntiAlias(true);
        this.j.setTextScaleX(1.1f);
        this.j.setTypeface(this.s);
        this.j.setTextSize(this.n);
        Paint paint3 = new Paint();
        this.k = paint3;
        paint3.setColor(this.v);
        this.k.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void i() {
        float f = this.x;
        if (f < 1.0f) {
            this.x = 1.0f;
        } else if (f > 4.0f) {
            this.x = 4.0f;
        }
    }

    private void j() {
        Rect rect = new Rect();
        for (int i = 0; i < this.l.a(); i++) {
            String strB = b(this.l.getItem(i));
            this.j.getTextBounds(strB, 0, strB.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.o) {
                this.o = iWidth;
            }
        }
        this.j.getTextBounds("星期", 0, 2, rect);
        int iHeight = rect.height() + 2;
        this.p = iHeight;
        this.r = this.x * iHeight;
    }

    private void k(String str) {
        String str2;
        Rect rect = new Rect();
        this.j.getTextBounds(str, 0, str.length(), rect);
        int i = this.T;
        if (i == 3) {
            this.U = 0;
            return;
        }
        if (i == 5) {
            this.U = (this.N - rect.width()) - ((int) this.W);
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.e || (str2 = this.m) == null || str2.equals(Constants.STR_EMPTY) || !this.f) {
            this.U = (int) (((double) (this.N - rect.width())) * 0.5d);
        } else {
            this.U = (int) (((double) (this.N - rect.width())) * 0.25d);
        }
    }

    private void l(String str) {
        String str2;
        Rect rect = new Rect();
        this.i.getTextBounds(str, 0, str.length(), rect);
        int i = this.T;
        if (i == 3) {
            this.V = 0;
            return;
        }
        if (i == 5) {
            this.V = (this.N - rect.width()) - ((int) this.W);
            return;
        }
        if (i != 17) {
            return;
        }
        if (this.e || (str2 = this.m) == null || str2.equals(Constants.STR_EMPTY) || !this.f) {
            this.V = (int) (((double) (this.N - rect.width())) * 0.5d);
        } else {
            this.V = (int) (((double) (this.N - rect.width())) * 0.25d);
        }
    }

    private void n() {
        if (this.l == null) {
            return;
        }
        j();
        int i = (int) (this.r * (this.L - 1));
        this.M = (int) (((double) (i * 2)) / 3.141592653589793d);
        this.O = (int) (((double) i) / 3.141592653589793d);
        this.N = View.MeasureSpec.getSize(this.S);
        int i2 = this.M;
        float f = this.r;
        this.z = (i2 - f) / 2.0f;
        float f2 = (i2 + f) / 2.0f;
        this.F = f2;
        this.G = (f2 - ((f - this.p) / 2.0f)) - this.W;
        if (this.I == -1) {
            if (this.y) {
                this.I = (this.l.a() + 1) / 2;
            } else {
                this.I = 0;
            }
        }
        this.K = this.I;
    }

    private void o(String str) {
        Rect rect = new Rect();
        this.j.getTextBounds(str, 0, str.length(), rect);
        int i = this.n;
        for (int iWidth = rect.width(); iWidth > this.N; iWidth = rect.width()) {
            i--;
            this.j.setTextSize(i);
            this.j.getTextBounds(str, 0, str.length(), rect);
        }
        this.i.setTextSize(i);
    }

    private void q(float f, float f2) {
        int i;
        int i2 = this.f229q;
        if (i2 > 0) {
            i = 1;
        } else {
            i = i2 < 0 ? -1 : 0;
        }
        this.i.setTextSkewX(i * (f2 <= 0.0f ? 1 : -1) * 0.5f * f);
        this.i.setAlpha(this.a0 ? (int) (((90.0f - Math.abs(f2)) / 90.0f) * 255.0f) : 255);
    }

    public void a() {
        ScheduledFuture scheduledFuture = this.h;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.h.cancel(true);
        this.h = null;
    }

    public int e(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        float[] fArr = new float[length];
        paint.getTextWidths(str, fArr);
        int iCeil = 0;
        for (int i = 0; i < length; i++) {
            iCeil += (int) Math.ceil(fArr[i]);
        }
        return iCeil;
    }

    public final ei3 getAdapter() {
        return this.l;
    }

    public final int getCurrentItem() {
        int i;
        ei3 ei3Var = this.l;
        if (ei3Var == null) {
            return 0;
        }
        return (!this.y || ((i = this.J) >= 0 && i < ei3Var.a())) ? Math.max(0, Math.min(this.J, this.l.a() - 1)) : Math.max(0, Math.min(Math.abs(Math.abs(this.J) - this.l.a()), this.l.a() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.c;
    }

    public int getInitPosition() {
        return this.I;
    }

    public float getItemHeight() {
        return this.r;
    }

    public int getItemsCount() {
        ei3 ei3Var = this.l;
        if (ei3Var != null) {
            return ei3Var.a();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.H;
    }

    public boolean h() {
        return this.y;
    }

    public final void m() {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        int i;
        Object item;
        boolean z;
        String strB;
        if (this.l == null) {
            return;
        }
        boolean z2 = false;
        int iMin = Math.min(Math.max(0, this.I), this.l.a() - 1);
        this.I = iMin;
        try {
            this.K = iMin + (((int) (this.H / this.r)) % this.l.a());
            while (true) {
                int i2 = this.L;
                if (i >= i2) {
                    return;
                }
                int i3 = this.K - ((i2 / 2) - i);
                if (this.y) {
                    item = this.l.getItem(d(i3));
                } else {
                    item = Constants.STR_EMPTY;
                    if (i3 >= 0 && i3 <= this.l.a() - 1) {
                        item = this.l.getItem(i3);
                    }
                }
                canvas.save();
                double d = ((this.r * i) - f) / this.O;
                float f2 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f2 > 90.0f || f2 < -90.0f) {
                    z = z2;
                    canvas.restore();
                } else {
                    if (this.f || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(b(item))) {
                        strB = b(item);
                    } else {
                        strB = b(item) + this.m;
                    }
                    float fPow = (float) Math.pow(Math.abs(f2) / 90.0f, 2.2d);
                    o(strB);
                    k(strB);
                    l(strB);
                    float fCos = (float) ((((double) this.O) - (Math.cos(d) * ((double) this.O))) - ((Math.sin(d) * ((double) this.p)) / 2.0d));
                    canvas.translate(0.0f, fCos);
                    float f3 = this.z;
                    if (fCos > f3 || this.p + fCos < f3) {
                        float f4 = this.F;
                        if (fCos > f4 || this.p + fCos < f4) {
                            if (fCos >= f3) {
                                int i4 = this.p;
                                if (i4 + fCos <= f4) {
                                    canvas.drawText(strB, this.U, i4 - this.W, this.j);
                                    this.J = this.K - ((this.L / 2) - i);
                                }
                                canvas.restore();
                                this.j.setTextSize(this.n);
                            }
                            canvas.save();
                            z = false;
                            canvas.clipRect(0, 0, this.N, (int) this.r);
                            canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                            q(fPow, f2);
                            canvas.drawText(strB, this.V + (this.f229q * fPow), this.p, this.i);
                            canvas.restore();
                            canvas.restore();
                            this.j.setTextSize(this.n);
                        } else {
                            canvas.save();
                            canvas.clipRect(0.0f, 0.0f, this.N, this.F - fCos);
                            canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                            canvas.drawText(strB, this.U, this.p - this.W, this.j);
                            canvas.restore();
                            canvas.save();
                            canvas.clipRect(0.0f, this.F - fCos, this.N, (int) this.r);
                            canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                            q(fPow, f2);
                            canvas.drawText(strB, this.V, this.p, this.i);
                            canvas.restore();
                        }
                    } else {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.N, this.z - fCos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        q(fPow, f2);
                        canvas.drawText(strB, this.V, this.p, this.i);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.z - fCos, this.N, (int) this.r);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(strB, this.U, this.p - this.W, this.j);
                        canvas.restore();
                    }
                    z = false;
                    canvas.restore();
                    this.j.setTextSize(this.n);
                }
                i++;
                z2 = z;
                f = f;
            }
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (this.y) {
            if (this.K < 0) {
                this.K = this.l.a() + this.K;
            }
            if (this.K > this.l.a() - 1) {
                this.K -= this.l.a();
            }
        } else {
            if (this.K < 0) {
                this.K = 0;
            }
            if (this.K > this.l.a() - 1) {
                this.K = this.l.a() - 1;
            }
        }
        f = this.H % this.r;
        DividerType dividerType = this.a;
        if (dividerType == DividerType.WRAP) {
            float f5 = (TextUtils.isEmpty(this.m) ? (this.N - this.o) / 2 : (this.N - this.o) / 4) - 12;
            float f6 = f5 <= 0.0f ? 10.0f : f5;
            float f7 = this.N - f6;
            float f8 = this.z;
            float f9 = f6;
            canvas.drawLine(f9, f8, f7, f8, this.k);
            float f10 = this.F;
            canvas.drawLine(f9, f10, f7, f10, this.k);
        } else if (dividerType == DividerType.CIRCLE) {
            this.k.setStyle(Paint.Style.STROKE);
            this.k.setStrokeWidth(this.w);
            float f11 = (TextUtils.isEmpty(this.m) ? (this.N - this.o) / 2.0f : (this.N - this.o) / 4.0f) - 12.0f;
            float f12 = f11 > 0.0f ? f11 : 10.0f;
            canvas.drawCircle(this.N / 2.0f, this.M / 2.0f, Math.max((this.N - f12) - f12, this.r) / 1.8f, this.k);
        } else {
            float f13 = this.z;
            canvas.drawLine(0.0f, f13, this.N, f13, this.k);
            float f14 = this.F;
            canvas.drawLine(0.0f, f14, this.N, f14, this.k);
        }
        if (!TextUtils.isEmpty(this.m) && this.f) {
            canvas.drawText(this.m, (this.N - e(this.j, this.m)) - this.W, this.G, this.j);
        }
        i = 0;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.S = i;
        n();
        setMeasuredDimension(this.N, this.M);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.d.onTouchEvent(motionEvent);
        float f = (-this.I) * this.r;
        float fA = ((this.l.a() - 1) - this.I) * this.r;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.R = System.currentTimeMillis();
            a();
            this.Q = motionEvent.getRawY();
        } else {
            if (action == 2) {
                float rawY = this.Q - motionEvent.getRawY();
                this.Q = motionEvent.getRawY();
                float f2 = this.H + rawY;
                this.H = f2;
                if (!this.y) {
                    float f3 = this.r;
                    if ((f2 - (f3 * 0.25f) < f && rawY < 0.0f) || ((f3 * 0.25f) + f2 > fA && rawY > 0.0f)) {
                        this.H = f2 - rawY;
                    }
                }
                return true;
            }
            if (!zOnTouchEvent) {
                float y = motionEvent.getY();
                int i = this.O;
                double dAcos = Math.acos((i - y) / i) * ((double) this.O);
                float f4 = this.r;
                this.P = (int) (((((int) ((dAcos + ((double) (f4 / 2.0f))) / ((double) f4))) - (this.L / 2)) * f4) - (((this.H % f4) + f4) % f4));
                if (System.currentTimeMillis() - this.R > 120) {
                    r(ACTION.DAGGLE);
                } else {
                    r(ACTION.CLICK);
                }
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void p(float f) {
        a();
        this.h = this.g.scheduleWithFixedDelay(new c21(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void r(ACTION action) {
        a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.H;
            float f2 = this.r;
            int i = (int) (((f % f2) + f2) % f2);
            this.P = i;
            if (i > f2 / 2.0f) {
                this.P = (int) (f2 - i);
            } else {
                this.P = -i;
            }
        }
        this.h = this.g.scheduleWithFixedDelay(new sr2(this, this.P), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void setAdapter(ei3 ei3Var) {
        this.l = ei3Var;
        n();
        invalidate();
    }

    public void setAlphaGradient(boolean z) {
        this.a0 = z;
    }

    public final void setCurrentItem(int i) {
        this.J = i;
        this.I = i;
        this.H = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z) {
        this.y = z;
    }

    public void setDividerColor(int i) {
        this.v = i;
        this.k.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.a = dividerType;
    }

    public void setDividerWidth(int i) {
        this.w = i;
        this.k.setStrokeWidth(i);
    }

    public void setGravity(int i) {
        this.T = i;
    }

    public void setIsOptions(boolean z) {
        this.e = z;
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 == 0) {
            i++;
        }
        this.L = i + 2;
    }

    public void setLabel(String str) {
        this.m = str;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.x = f;
            i();
        }
    }

    public final void setOnItemSelectedListener(kv1 kv1Var) {
    }

    public void setTextColorCenter(int i) {
        this.u = i;
        this.j.setColor(i);
    }

    public void setTextColorOut(int i) {
        this.t = i;
        this.i.setColor(i);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.b.getResources().getDisplayMetrics().density * f);
            this.n = i;
            this.i.setTextSize(i);
            this.j.setTextSize(this.n);
        }
    }

    public void setTextXOffset(int i) {
        this.f229q = i;
        if (i != 0) {
            this.j.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f) {
        this.H = f;
    }

    public final void setTypeface(Typeface typeface) {
        this.s = typeface;
        this.i.setTypeface(typeface);
        this.j.setTypeface(this.s);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.f = true;
        this.g = Executors.newSingleThreadScheduledExecutor();
        this.s = Typeface.MONOSPACE;
        this.x = 1.6f;
        this.L = 11;
        this.P = 0;
        this.Q = 0.0f;
        this.R = 0L;
        this.T = 17;
        this.U = 0;
        this.V = 0;
        this.a0 = false;
        this.n = getResources().getDimensionPixelSize(R$dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.W = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.W = 4.0f;
        } else if (2.0f <= f && f < 3.0f) {
            this.W = 6.0f;
        } else if (f >= 3.0f) {
            this.W = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.pickerview, 0, 0);
            this.T = typedArrayObtainStyledAttributes.getInt(R$styleable.pickerview_wheelview_gravity, 17);
            this.t = typedArrayObtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorOut, -5723992);
            this.u = typedArrayObtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.v = typedArrayObtainStyledAttributes.getColor(R$styleable.pickerview_wheelview_dividerColor, -2763307);
            this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.pickerview_wheelview_dividerWidth, 2);
            this.n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.pickerview_wheelview_textSize, this.n);
            this.x = typedArrayObtainStyledAttributes.getFloat(R$styleable.pickerview_wheelview_lineSpacingMultiplier, this.x);
            typedArrayObtainStyledAttributes.recycle();
        }
        i();
        f(context);
    }
}
