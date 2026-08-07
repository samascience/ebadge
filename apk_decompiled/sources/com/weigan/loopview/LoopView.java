package com.weigan.loopview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.connect.common.Constants;
import defpackage.jv1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class LoopView extends View {
    private static final int P = (int) (Resources.getSystem().getDisplayMetrics().density * 15.0f);
    int F;
    int G;
    int H;
    int I;
    private int J;
    private float K;
    long L;
    private Rect M;
    private int N;
    private int O;
    private float a;
    private Context b;
    Handler c;
    private GestureDetector d;
    ScheduledExecutorService e;
    private ScheduledFuture f;
    private Paint g;
    private Paint h;
    private Paint i;
    List j;
    int k;
    int l;
    int m;
    int n;
    int o;
    float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f315q;
    int r;
    int s;
    int t;
    int u;
    private int v;
    int w;
    int x;
    int y;
    HashMap z;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public LoopView(Context context) {
        super(context);
        this.a = 1.05f;
        this.e = Executors.newSingleThreadScheduledExecutor();
        this.J = 0;
        this.L = 0L;
        this.M = new Rect();
        d(context, null);
    }

    private int c(String str, Paint paint, Rect rect) {
        paint.getTextBounds(str, 0, str.length(), rect);
        int iWidth = (int) (rect.width() * this.a);
        int i = this.G;
        int i2 = this.N;
        return (((i - i2) - iWidth) / 2) + i2;
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.b = context;
        this.c = new c(this);
        GestureDetector gestureDetector = new GestureDetector(context, new b(this));
        this.d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.androidWheelView);
        this.k = typedArrayObtainStyledAttributes.getInteger(R$styleable.androidWheelView_awv_textsize, P);
        this.k = (int) (Resources.getSystem().getDisplayMetrics().density * this.k);
        this.p = typedArrayObtainStyledAttributes.getFloat(R$styleable.androidWheelView_awv_lineSpace, 2.0f);
        this.n = typedArrayObtainStyledAttributes.getInteger(R$styleable.androidWheelView_awv_centerTextColor, -13553359);
        this.m = typedArrayObtainStyledAttributes.getInteger(R$styleable.androidWheelView_awv_outerTextColor, -5263441);
        this.o = typedArrayObtainStyledAttributes.getInteger(R$styleable.androidWheelView_awv_dividerTextColor, -3815995);
        int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.androidWheelView_awv_itemsVisibleCount, 9);
        this.y = integer;
        if (integer % 2 == 0) {
            this.y = 9;
        }
        this.f315q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.androidWheelView_awv_isLoop, true);
        typedArrayObtainStyledAttributes.recycle();
        this.z = new HashMap();
        this.t = 0;
        this.u = -1;
        e();
    }

    private void e() {
        Paint paint = new Paint();
        this.g = paint;
        paint.setColor(this.m);
        this.g.setAntiAlias(true);
        Paint paint2 = this.g;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        paint2.setTypeface(typeface);
        this.g.setTextSize(this.k);
        Paint paint3 = new Paint();
        this.h = paint3;
        paint3.setColor(this.n);
        this.h.setAntiAlias(true);
        this.h.setTextScaleX(this.a);
        this.h.setTypeface(typeface);
        this.h.setTextSize(this.k);
        Paint paint4 = new Paint();
        this.i = paint4;
        paint4.setColor(this.o);
        this.i.setAntiAlias(true);
    }

    private void g() {
        if (this.j == null) {
            return;
        }
        this.G = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.F = measuredHeight;
        if (this.G == 0 || measuredHeight == 0) {
            return;
        }
        this.N = getPaddingLeft();
        int paddingRight = getPaddingRight();
        this.O = paddingRight;
        this.G -= paddingRight;
        this.h.getTextBounds("星期", 0, 2, this.M);
        this.M.height();
        int i = this.F;
        int i2 = (int) ((((double) i) * 3.141592653589793d) / 2.0d);
        this.H = i2;
        float f = this.p;
        int i3 = (int) (i2 / ((this.y - 1) * f));
        this.l = i3;
        this.I = i / 2;
        this.r = (int) ((i - (i3 * f)) / 2.0f);
        this.s = (int) ((i + (f * i3)) / 2.0f);
        if (this.u == -1) {
            if (this.f315q) {
                this.u = (this.j.size() + 1) / 2;
            } else {
                this.u = 0;
            }
        }
        this.w = this.u;
    }

    public void a() {
        ScheduledFuture scheduledFuture = this.f;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f.cancel(true);
        this.f = null;
    }

    public List b(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new a(i, (String) list.get(i)));
        }
        return arrayList;
    }

    protected final void f() {
    }

    public final int getSelectedItem() {
        return this.v;
    }

    protected final void h(float f) {
        a();
        this.f = this.e.scheduleWithFixedDelay(new com.weigan.loopview.a(this, f), 0L, 10, TimeUnit.MILLISECONDS);
    }

    void i(ACTION action) {
        a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            float f = this.p * this.l;
            int i = (int) (((this.t % f) + f) % f);
            this.J = i;
            if (i > f / 2.0f) {
                this.J = (int) (f - i);
            } else {
                this.J = -i;
            }
        }
        this.f = this.e.scheduleWithFixedDelay(new d(this, this.J), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        List list = this.j;
        if (list == null) {
            return;
        }
        int i = (int) (this.t / (this.p * this.l));
        this.x = i;
        int size = this.u + (i % list.size());
        this.w = size;
        if (this.f315q) {
            if (size < 0) {
                this.w = this.j.size() + this.w;
            }
            if (this.w > this.j.size() - 1) {
                this.w -= this.j.size();
            }
        } else {
            if (size < 0) {
                this.w = 0;
            }
            if (this.w > this.j.size() - 1) {
                this.w = this.j.size() - 1;
            }
        }
        int i2 = (int) (this.t % (this.p * this.l));
        int i3 = 0;
        while (true) {
            int i4 = this.y;
            if (i3 >= i4) {
                break;
            }
            int size2 = this.w - ((i4 / 2) - i3);
            if (this.f315q) {
                while (size2 < 0) {
                    size2 += this.j.size();
                }
                while (size2 > this.j.size() - 1) {
                    size2 -= this.j.size();
                }
                this.z.put(Integer.valueOf(i3), (a) this.j.get(size2));
            } else if (size2 < 0) {
                this.z.put(Integer.valueOf(i3), new a());
            } else if (size2 > this.j.size() - 1) {
                this.z.put(Integer.valueOf(i3), new a());
            } else {
                this.z.put(Integer.valueOf(i3), (a) this.j.get(size2));
            }
            i3++;
        }
        float f = this.N;
        int i5 = this.r;
        canvas.drawLine(f, i5, this.G, i5, this.i);
        float f2 = this.N;
        int i6 = this.s;
        canvas.drawLine(f2, i6, this.G, i6, this.i);
        for (int i7 = 0; i7 < this.y; i7++) {
            canvas.save();
            float f3 = this.l * this.p;
            double d = (((double) ((i7 * f3) - i2)) * 3.141592653589793d) / ((double) this.H);
            if (d >= 3.141592653589793d || d <= 0.0d) {
                canvas.restore();
            } else {
                int iCos = (int) ((((double) this.I) - (Math.cos(d) * ((double) this.I))) - ((Math.sin(d) * ((double) this.l)) / 2.0d));
                canvas.translate(0.0f, iCos);
                canvas.scale(1.0f, (float) Math.sin(d));
                int i8 = this.r;
                if (iCos > i8 || this.l + iCos < i8) {
                    int i9 = this.s;
                    if (iCos <= i9 && this.l + iCos >= i9) {
                        canvas.save();
                        canvas.clipRect(0, 0, this.G, this.s - iCos);
                        canvas.drawText(((a) this.z.get(Integer.valueOf(i7))).a, c(((a) this.z.get(Integer.valueOf(i7))).a, this.h, this.M), this.l, this.h);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0, this.s - iCos, this.G, (int) f3);
                        canvas.drawText(((a) this.z.get(Integer.valueOf(i7))).a, c(((a) this.z.get(Integer.valueOf(i7))).a, this.g, this.M), this.l, this.g);
                        canvas.restore();
                    } else if (iCos < i8 || this.l + iCos > i9) {
                        canvas.clipRect(0, 0, this.G, (int) f3);
                        canvas.drawText(((a) this.z.get(Integer.valueOf(i7))).a, c(((a) this.z.get(Integer.valueOf(i7))).a, this.g, this.M), this.l, this.g);
                    } else {
                        canvas.clipRect(0, 0, this.G, (int) f3);
                        canvas.drawText(((a) this.z.get(Integer.valueOf(i7))).a, c(((a) this.z.get(Integer.valueOf(i7))).a, this.h, this.M), this.l, this.h);
                        this.v = this.j.indexOf(this.z.get(Integer.valueOf(i7)));
                    }
                } else {
                    canvas.save();
                    canvas.clipRect(0, 0, this.G, this.r - iCos);
                    canvas.drawText(((a) this.z.get(Integer.valueOf(i7))).a, c(((a) this.z.get(Integer.valueOf(i7))).a, this.g, this.M), this.l, this.g);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.r - iCos, this.G, (int) f3);
                    canvas.drawText(((a) this.z.get(Integer.valueOf(i7))).a, c(((a) this.z.get(Integer.valueOf(i7))).a, this.h, this.M), this.l, this.h);
                    canvas.restore();
                }
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        g();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.d.onTouchEvent(motionEvent);
        float f = this.p * this.l;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.L = System.currentTimeMillis();
            a();
            this.K = motionEvent.getRawY();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!zOnTouchEvent) {
                float y = motionEvent.getY();
                int i = this.I;
                this.J = (int) (((((int) (((Math.acos((i - y) / i) * ((double) this.I)) + ((double) (f / 2.0f))) / ((double) f))) - (this.y / 2)) * f) - (((this.t % f) + f) % f));
                if (System.currentTimeMillis() - this.L > 120) {
                    i(ACTION.DAGGLE);
                } else {
                    i(ACTION.CLICK);
                }
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            float rawY = this.K - motionEvent.getRawY();
            this.K = motionEvent.getRawY();
            this.t = (int) (this.t + rawY);
            if (!this.f315q) {
                float f2 = (-this.u) * f;
                float size = ((this.j.size() - 1) - this.u) * f;
                int i2 = this.t;
                if (i2 < f2) {
                    this.t = (int) f2;
                } else if (i2 > size) {
                    this.t = (int) size;
                }
            }
        }
        invalidate();
        return true;
    }

    public void setCenterTextColor(int i) {
        this.n = i;
        this.h.setColor(i);
    }

    public void setCurrentPosition(int i) {
        List list = this.j;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.j.size();
        if (i < 0 || i >= size || i == this.v) {
            return;
        }
        this.u = i;
        this.t = 0;
        this.J = 0;
        invalidate();
    }

    public void setDividerColor(int i) {
        this.o = i;
        this.i.setColor(i);
    }

    public final void setInitPosition(int i) {
        if (i < 0) {
            this.u = 0;
            return;
        }
        List list = this.j;
        if (list == null || list.size() <= i) {
            return;
        }
        this.u = i;
    }

    public final void setItems(List<String> list) {
        this.j = b(list);
        g();
        invalidate();
    }

    public void setItemsVisibleCount(int i) {
        if (i % 2 == 0 || i == this.y) {
            return;
        }
        this.y = i;
        this.z = new HashMap();
    }

    public void setLineSpacingMultiplier(float f) {
        if (f > 1.0f) {
            this.p = f;
        }
    }

    public final void setListener(jv1 jv1Var) {
    }

    public void setOuterTextColor(int i) {
        this.m = i;
        this.g.setColor(i);
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        this.a = f;
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            int i = (int) (this.b.getResources().getDisplayMetrics().density * f);
            this.k = i;
            this.g.setTextSize(i);
            this.h.setTextSize(this.k);
        }
    }

    class a {
        private String a;
        private int b;

        public a() {
            this.a = Constants.STR_EMPTY;
        }

        public a(int i, String str) {
            this.b = i;
            this.a = str;
        }
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1.05f;
        this.e = Executors.newSingleThreadScheduledExecutor();
        this.J = 0;
        this.L = 0L;
        this.M = new Rect();
        d(context, attributeSet);
    }

    public LoopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1.05f;
        this.e = Executors.newSingleThreadScheduledExecutor();
        this.J = 0;
        this.L = 0L;
        this.M = new Rect();
        d(context, attributeSet);
    }
}
