package xfkj.fitpro.view.seekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.q30;
import defpackage.xa3;
import java.text.DecimalFormat;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private boolean A;
    private Bitmap B;
    private Bitmap C;
    private Bitmap D;
    private ValueAnimator E;
    private String F;
    private RangeSeekBar H;
    private String I;
    private DecimalFormat N;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private float i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f442q;
    private float r;
    private int s;
    protected int t;
    protected int u;
    protected int v;
    protected int w;
    protected float x;
    private boolean z;
    protected float y = 0.0f;
    private boolean G = false;
    private Path J = new Path();
    private Rect K = new Rect();
    private Rect L = new Rect();
    private Paint M = new Paint(1);

    /* JADX INFO: renamed from: xfkj.fitpro.view.seekbar.a$a, reason: collision with other inner class name */
    class C0181a implements ValueAnimator.AnimatorUpdateListener {
        C0181a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.y = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (a.this.H != null) {
                a.this.H.invalidate();
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            aVar.y = 0.0f;
            if (aVar.H != null) {
                a.this.H.invalidate();
            }
        }
    }

    public a(RangeSeekBar rangeSeekBar, AttributeSet attributeSet, boolean z) {
        this.H = rangeSeekBar;
        this.A = z;
        l(attributeSet);
        n();
        m();
    }

    private void d(Canvas canvas, String str) {
        int iHeight;
        this.M.setStyle(Paint.Style.FILL);
        this.M.setColor(this.j);
        int iWidth = this.K.width() + this.k + this.l;
        int i = this.c;
        if (i > 0 && i >= iWidth) {
            iWidth = i;
        }
        int iB = xa3.b(f(), 7.0f);
        this.d = iB;
        Rect rect = this.L;
        int i2 = this.f442q;
        int i3 = (i2 / 2) - (iWidth / 2);
        rect.left = i3;
        int i4 = this.w;
        int i5 = this.b;
        int i6 = ((i4 - i5) - i2) - iB;
        rect.top = i6;
        rect.right = i3 + iWidth;
        rect.bottom = i6 + i5;
        int iB2 = xa3.b(f(), 1.0f);
        int iWidth2 = (((this.L.width() / 2) - ((int) (this.s * this.x))) - this.H.getLineLeft()) + iB2;
        int iWidth3 = (((this.L.width() / 2) - ((int) (this.s * (1.0f - this.x)))) - this.H.getLinePaddingRight()) + iB2;
        if (iWidth2 > 0) {
            Rect rect2 = this.L;
            rect2.left += iWidth2;
            rect2.right += iWidth2;
        } else if (iWidth3 > 0) {
            Rect rect3 = this.L;
            rect3.left -= iWidth3;
            rect3.right -= iWidth3;
        }
        Bitmap bitmap = this.D;
        if (bitmap != null) {
            xa3.c(canvas, bitmap, this.L);
        } else if (this.i > 0.0f) {
            RectF rectF = new RectF(this.L);
            float f = this.i;
            canvas.drawRoundRect(rectF, f, f, this.M);
        } else {
            canvas.drawRect(this.L, this.M);
        }
        if (this.m > 0) {
            iHeight = this.L.top + this.K.height() + this.m;
        } else {
            iHeight = this.n > 0 ? (this.L.bottom - this.K.height()) - this.n : (this.L.bottom - ((this.b - this.K.height()) / 2)) + 1;
        }
        this.M.setColor(this.h);
        Rect rect4 = new Rect();
        this.M.getTextBounds(str, 0, str.length(), rect4);
        canvas.drawText(str, this.L.centerX() - (rect4.width() / 2), iHeight, this.M);
    }

    private void e(Canvas canvas) {
        Bitmap bitmap = this.C;
        if (bitmap != null && !this.G) {
            canvas.drawBitmap(bitmap, 0.0f, this.H.getLineTop() + ((this.H.getProgressHeight() - this.f442q) / 2), (Paint) null);
            return;
        }
        Bitmap bitmap2 = this.B;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, this.H.getLineTop() + ((this.H.getProgressHeight() - this.f442q) / 2), (Paint) null);
        }
    }

    private Context f() {
        return this.H.getContext();
    }

    private void l(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = f().obtainStyledAttributes(attributeSet, R$styleable.RangeSeekBar);
        if (typedArrayObtainStyledAttributes == null) {
            return;
        }
        this.d = (int) typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        this.e = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.a = typedArrayObtainStyledAttributes.getInt(10, 1);
        this.b = (int) typedArrayObtainStyledAttributes.getDimension(3, 0.0f);
        this.c = (int) typedArrayObtainStyledAttributes.getDimension(13, 0.0f);
        this.g = (int) typedArrayObtainStyledAttributes.getDimension(12, xa3.b(f(), 14.0f));
        this.h = typedArrayObtainStyledAttributes.getColor(11, -1);
        this.j = typedArrayObtainStyledAttributes.getColor(1, q30.c(f(), R.color.colorAccent));
        this.k = (int) typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
        this.l = (int) typedArrayObtainStyledAttributes.getDimension(7, 0.0f);
        this.m = (int) typedArrayObtainStyledAttributes.getDimension(8, 0.0f);
        this.n = (int) typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.f = (int) typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.o = typedArrayObtainStyledAttributes.getResourceId(26, R.drawable.rsb_default_thumb);
        this.p = typedArrayObtainStyledAttributes.getResourceId(27, 0);
        this.f442q = (int) typedArrayObtainStyledAttributes.getDimension(29, xa3.b(f(), 26.0f));
        this.r = typedArrayObtainStyledAttributes.getFloat(28, 1.0f);
        this.i = typedArrayObtainStyledAttributes.getDimension(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void m() {
    }

    private void n() {
        if (this.b <= 0 && this.a != 1) {
            throw new IllegalArgumentException("if you want to show indicator, the indicatorHeight must > 0");
        }
        if (this.f <= 0) {
            this.f = this.f442q / 4;
        }
    }

    protected boolean b(float f, float f2) {
        int i = (int) (this.s * this.x);
        return f > ((float) (this.t + i)) && f < ((float) (this.u + i)) && f2 > ((float) this.v) && f2 < ((float) this.w);
    }

    protected void c(Canvas canvas) {
        int i = (int) (this.s * this.x);
        canvas.save();
        canvas.translate(i, 0.0f);
        xfkj.fitpro.view.seekbar.b[] rangeSeekBarState = this.H.getRangeSeekBarState();
        String str = this.F;
        if (this.A) {
            if (str == null) {
                DecimalFormat decimalFormat = this.N;
                str = decimalFormat != null ? decimalFormat.format(rangeSeekBarState[0].b) : rangeSeekBarState[0].a;
            }
        } else if (str == null) {
            DecimalFormat decimalFormat2 = this.N;
            str = decimalFormat2 != null ? decimalFormat2.format(rangeSeekBarState[1].b) : rangeSeekBarState[1].a;
        }
        String str2 = this.I;
        if (str2 != null) {
            str = String.format(str2, str);
        }
        this.M.setTextSize(this.g);
        this.M.getTextBounds(str, 0, str.length(), this.K);
        canvas.translate(this.t, 0.0f);
        if (this.a == 3) {
            u(true);
        }
        if (this.z) {
            d(canvas, this.H.getRealData() + this.H.getLabel());
        }
        e(canvas);
        canvas.restore();
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.b;
    }

    public int i() {
        return this.a;
    }

    public float j() {
        return this.r;
    }

    public int k() {
        return this.f442q;
    }

    public void o() {
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.y, 0.0f);
        this.E = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new C0181a());
        this.E.addListener(new b());
        this.E.start();
    }

    protected void p(int i, int i2, int i3) {
        n();
        m();
        int i4 = this.f442q;
        this.t = i - (i4 / 2);
        this.u = i + (i4 / 2);
        this.v = i2 - (i4 / 2);
        this.w = i2 + (i4 / 2);
        this.s = i3;
    }

    protected void q(boolean z) {
        this.G = z;
    }

    public void r(String str) {
        this.F = str;
    }

    public void s(String str) {
        this.N = new DecimalFormat(str);
    }

    public void t(String str) {
        this.I = str;
    }

    protected void u(boolean z) {
        int i = this.a;
        if (i == 0) {
            this.z = z;
            return;
        }
        if (i == 1) {
            this.z = false;
        } else if (i == 2 || i == 3) {
            this.z = true;
        }
    }

    public void v(int i) {
        this.f442q = i;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0005 A[PHI: r0
      0x0005: PHI (r0v2 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0003, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    protected void w(float f) {
        float f2 = 0.0f;
        if (f < 0.0f) {
            f = f2;
        } else {
            f2 = 1.0f;
            if (f > 1.0f) {
                f = f2;
            }
        }
        this.x = f;
    }
}
