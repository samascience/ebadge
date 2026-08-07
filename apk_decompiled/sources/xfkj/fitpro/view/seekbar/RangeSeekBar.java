package xfkj.fitpro.view.seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.connect.common.Constants;
import defpackage.kr2;
import defpackage.xa3;
import defpackage.xv1;
import xfkj.fitpro.R$styleable;

/* JADX INFO: loaded from: classes4.dex */
public class RangeSeekBar extends View {
    private boolean F;
    private boolean G;
    private Paint H;
    private RectF I;
    private RectF J;
    private a K;
    private a L;
    private a M;
    private int N;
    float O;
    private String P;
    private CharSequence[] Q;
    private float R;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private CharSequence[] i;
    private float j;
    private int k;
    private int l;
    private int m;
    private float n;
    private int o;
    private float p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f441q;
    private int r;
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    private int w;
    private float x;
    private float y;
    private float z;

    public RangeSeekBar(Context context) {
        this(context, null);
    }

    private void a(boolean z) {
        a aVar;
        if (!z || (aVar = this.M) == null) {
            a aVar2 = this.K;
            if (aVar2 != null) {
                aVar2.q(false);
            }
            a aVar3 = this.L;
            if (aVar3 != null) {
                aVar3.q(false);
                return;
            }
            return;
        }
        a aVar4 = this.K;
        boolean z2 = aVar == aVar4;
        if (aVar4 != null) {
            aVar4.q(z2);
        }
        a aVar5 = this.L;
        if (aVar5 != null) {
            aVar5.q(!z2);
        }
    }

    private void d(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.RangeSeekBar);
        this.a = typedArrayObtainStyledAttributes.getInt(18, 2);
        this.p = typedArrayObtainStyledAttributes.getFloat(17, 0.0f);
        this.f441q = typedArrayObtainStyledAttributes.getFloat(16, 100.0f);
        this.n = typedArrayObtainStyledAttributes.getFloat(24, 0.0f);
        this.k = typedArrayObtainStyledAttributes.getColor(20, -11806366);
        this.j = (int) typedArrayObtainStyledAttributes.getDimension(23, -1.0f);
        this.l = typedArrayObtainStyledAttributes.getColor(21, -2631721);
        this.m = (int) typedArrayObtainStyledAttributes.getDimension(22, xa3.b(getContext(), 2.0f));
        this.b = typedArrayObtainStyledAttributes.getInt(33, 0);
        this.f = typedArrayObtainStyledAttributes.getInt(30, 1);
        this.c = typedArrayObtainStyledAttributes.getInt(34, 1);
        this.i = typedArrayObtainStyledAttributes.getTextArray(35);
        this.d = (int) typedArrayObtainStyledAttributes.getDimension(37, xa3.b(getContext(), 7.0f));
        this.e = (int) typedArrayObtainStyledAttributes.getDimension(38, xa3.b(getContext(), 12.0f));
        this.g = typedArrayObtainStyledAttributes.getColor(36, this.l);
        this.h = typedArrayObtainStyledAttributes.getColor(36, this.k);
        this.N = typedArrayObtainStyledAttributes.getInt(25, 15);
        this.P = typedArrayObtainStyledAttributes.getString(14);
        this.R = typedArrayObtainStyledAttributes.getFloat(15, 80.0f);
        String str = this.P;
        if (str == null) {
            str = Constants.STR_EMPTY;
        }
        this.P = str;
        this.Q = typedArrayObtainStyledAttributes.getTextArray(32);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void e() {
        this.H.setStyle(Paint.Style.FILL);
        this.H.setColor(this.l);
        this.H.setTextSize(this.e);
    }

    private void f() {
        if (this.L == null) {
            this.s = (int) (((this.K.h() + this.K.g()) + ((this.K.k() * this.K.j()) / 2.0f)) - (this.m / 2));
        } else {
            this.s = (int) (Math.max((this.K.h() + this.K.g()) + ((this.K.k() * this.K.j()) / 2.0f), (this.L.h() + this.L.g()) + (this.L.k() / 2)) - (this.m / 2));
        }
        this.t = this.s + this.m;
        if (this.j < 0.0f) {
            this.j = (int) ((getLineBottom() - getLineTop()) * 0.45f);
        }
    }

    private void g() {
        a aVar = this.M;
        if (aVar == null || aVar.j() <= 1.0f || !this.G) {
            return;
        }
        this.G = false;
        a aVar2 = this.M;
        aVar2.v((int) (aVar2.k() / this.M.j()));
        this.M.p(getLineLeft(), getLineBottom(), this.r);
    }

    private void h() {
        a aVar = this.M;
        if (aVar == null || aVar.j() <= 1.0f || this.G) {
            return;
        }
        this.G = true;
        a aVar2 = this.M;
        aVar2.v((int) (aVar2.k() * this.M.j()));
        this.M.p(getLineLeft(), getLineBottom(), this.r);
    }

    protected float b(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    protected float c(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    public String getLabel() {
        return this.P;
    }

    public a getLeftSeekBar() {
        return this.K;
    }

    public int getLineBottom() {
        return this.t;
    }

    public int getLineLeft() {
        return this.u;
    }

    public int getLinePaddingRight() {
        return this.w;
    }

    public int getLineRight() {
        return this.v;
    }

    public int getLineTop() {
        return this.s;
    }

    public int getLineWidth() {
        return this.r;
    }

    public float getMaxProgress() {
        return this.f441q;
    }

    public float getMinProgress() {
        return this.p;
    }

    public int getProgressColor() {
        return this.k;
    }

    public int getProgressDefaultColor() {
        return this.l;
    }

    public int getProgressHeight() {
        return this.m;
    }

    public float getProgressRadius() {
        return this.j;
    }

    public float getRangeInterval() {
        return this.n;
    }

    public b[] getRangeSeekBarState() {
        float f = this.f441q - this.p;
        b bVar = new b();
        float f2 = this.p;
        float f3 = this.K.x;
        bVar.b = f2 + (f * f3);
        int i = this.c;
        if (i > 1) {
            int iFloor = (int) Math.floor(f3 * i);
            CharSequence[] charSequenceArr = this.i;
            if (charSequenceArr != null && iFloor >= 0 && iFloor < charSequenceArr.length) {
                bVar.a = charSequenceArr[iFloor].toString();
            }
            if (iFloor == 0) {
                bVar.c = true;
            } else if (iFloor == this.c) {
                bVar.d = true;
            }
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(bVar.b);
            bVar.a = stringBuffer.toString();
            if (xa3.a(this.K.x, 0.0f) == 0) {
                bVar.c = true;
            } else if (xa3.a(this.K.x, 1.0f) == 0) {
                bVar.d = true;
            }
        }
        b bVar2 = new b();
        a aVar = this.L;
        if (aVar != null) {
            float f4 = this.p;
            float f5 = aVar.x;
            bVar2.b = f4 + (f * f5);
            int i2 = this.c;
            if (i2 > 1) {
                int iFloor2 = (int) Math.floor(f5 * i2);
                CharSequence[] charSequenceArr2 = this.i;
                if (charSequenceArr2 != null && iFloor2 >= 0 && iFloor2 < charSequenceArr2.length) {
                    bVar2.a = charSequenceArr2[iFloor2].toString();
                }
                if (iFloor2 == 0) {
                    bVar2.c = true;
                } else if (iFloor2 == this.c) {
                    bVar2.d = true;
                }
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(bVar2.b);
                bVar2.a = stringBuffer2.toString();
                if (xa3.a(this.L.x, 0.0f) == 0) {
                    bVar2.c = true;
                } else if (xa3.a(this.L.x, 1.0f) == 0) {
                    bVar2.d = true;
                }
            }
        }
        return new b[]{bVar, bVar2};
    }

    public float getRealData() {
        return this.O;
    }

    public a getRightSeekBar() {
        return this.L;
    }

    public int getSeekBarMode() {
        return this.a;
    }

    public int getStartValue() {
        return this.N;
    }

    public int getTickMarkGravity() {
        return this.f;
    }

    public int getTickMarkInRangeTextColor() {
        return this.h;
    }

    public int getTickMarkMode() {
        return this.b;
    }

    public int getTickMarkNumber() {
        return this.c;
    }

    public CharSequence[] getTickMarkTextArray() {
        return this.i;
    }

    public int getTickMarkTextColor() {
        return this.g;
    }

    public int getTickMarkTextMargin() {
        return this.d;
    }

    public int getTickMarkTextSize() {
        return this.e;
    }

    public void i(float f, float f2, float f3, int i) {
        if (f2 <= f) {
            throw new IllegalArgumentException("setRange() max must be greater than min ! #max:" + f2 + " #min:" + f);
        }
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("setRange() interval must be greater than zero ! #interval:" + f3);
        }
        float f4 = f2 - f;
        if (f3 >= f4) {
            throw new IllegalArgumentException("setRange() interval must be less than (max - min) ! #interval:" + f3 + " #max - min:" + f4);
        }
        if (i < 1) {
            throw new IllegalArgumentException("setRange() tickMarkNumber must be greater than 1 ! #tickMarkNumber:" + i);
        }
        this.f441q = f2;
        this.p = f;
        this.c = i;
        float f5 = 1.0f / i;
        this.y = f5;
        this.n = f3;
        float f6 = f3 / f4;
        this.z = f6;
        int i2 = (int) ((f6 / f5) + (f6 % f5 != 0.0f ? 1 : 0));
        this.o = i2;
        if (i > 1) {
            a aVar = this.L;
            if (aVar != null) {
                a aVar2 = this.K;
                float f7 = aVar2.x;
                if ((i2 * f5) + f7 > 1.0f || (i2 * f5) + f7 <= aVar.x) {
                    float f8 = aVar.x;
                    if (f8 - (i2 * f5) >= 0.0f && f8 - (i2 * f5) < f7) {
                        aVar2.x = f8 - (f5 * i2);
                    }
                } else {
                    aVar.x = f7 + (f5 * i2);
                }
            } else if (1.0f - (i2 * f5) >= 0.0f) {
                float f9 = 1.0f - (i2 * f5);
                a aVar3 = this.K;
                if (f9 < aVar3.x) {
                    aVar3.x = 1.0f - (f5 * i2);
                }
            }
        } else {
            a aVar4 = this.L;
            if (aVar4 != null) {
                a aVar5 = this.K;
                float f10 = aVar5.x;
                if (f10 + f6 > 1.0f || f10 + f6 <= aVar4.x) {
                    float f11 = aVar4.x;
                    if (f11 - f6 >= 0.0f && f11 - f6 < f10) {
                        aVar5.x = f11 - f6;
                    }
                } else {
                    aVar4.x = f10 + f6;
                }
            } else if (1.0f - f6 >= 0.0f) {
                float f12 = 1.0f - f6;
                a aVar6 = this.K;
                if (f12 < aVar6.x) {
                    aVar6.x = 1.0f - f6;
                }
            }
        }
        invalidate();
    }

    public void j(float f, float f2) {
        float fMin = Math.min(f, f2);
        float fMax = Math.max(fMin, f2);
        float f3 = this.p;
        if (fMin < f3) {
            fMin = f3;
        }
        float f4 = this.f441q;
        if (fMax > f4) {
            fMax = f4;
        }
        float f5 = fMax - fMin;
        float f6 = this.n;
        if (f5 < f6) {
            fMin = fMax - f6;
        }
        float f7 = f4 - f3;
        int i = this.c;
        if (i > 1) {
            int i2 = (int) (f7 / i);
            if (((int) Math.abs(fMin - f3)) % i2 != 0 || ((int) Math.abs(fMax - this.p)) % i2 != 0) {
                throw new IllegalArgumentException("The current value must be at the equal point");
            }
            this.K.x = Math.abs(fMin - this.p) / f7;
            a aVar = this.L;
            if (aVar != null) {
                aVar.x = Math.abs(fMax - this.p) / f7;
            }
        } else {
            this.K.x = Math.abs(fMin - f3) / f7;
            a aVar2 = this.L;
            if (aVar2 != null) {
                aVar2.x = Math.abs(fMax - this.p) / f7;
            }
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float fMeasureText;
        float lineLeft;
        float fMeasureText2;
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(kr2.a(10.0f));
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.l);
        CharSequence[] charSequenceArr = this.i;
        if (charSequenceArr != null) {
            int length = this.r / (charSequenceArr.length - 1);
            int i = 0;
            float f = 0.0f;
            while (true) {
                CharSequence[] charSequenceArr2 = this.i;
                if (i >= charSequenceArr2.length) {
                    break;
                }
                String string = charSequenceArr2[i].toString();
                String string2 = this.Q[i].toString();
                this.H.setColor(this.g);
                if (this.b == 1) {
                    int i2 = this.f;
                    if (i2 == 2) {
                        lineLeft = getLineLeft() + (i * length);
                        fMeasureText2 = this.H.measureText(string);
                    } else if (i2 == 1) {
                        lineLeft = getLineLeft() + (i * length);
                        fMeasureText2 = this.H.measureText(string) / 2.0f;
                    } else {
                        fMeasureText = getLineLeft() + (i * length);
                    }
                    fMeasureText = lineLeft - fMeasureText2;
                } else {
                    float f2 = Float.parseFloat(string);
                    b[] rangeSeekBarState = getRangeSeekBarState();
                    if (xa3.a(f2, rangeSeekBarState[0].b) != -1 && xa3.a(f2, rangeSeekBarState[1].b) != 1 && this.a == 2) {
                        this.H.setColor(this.h);
                    }
                    float lineLeft2 = getLineLeft();
                    float f3 = this.r;
                    float f4 = this.p;
                    fMeasureText = (lineLeft2 + ((f3 * (f2 - f4)) / (this.f441q - f4))) - (this.H.measureText(string) / 2.0f);
                }
                Rect rect = new Rect();
                this.H.getTextBounds(string, 0, string.length(), rect);
                float lineTop = getLineTop() + this.m + this.d + rect.height();
                float fFloatValue = Float.valueOf(string).floatValue();
                if ((fFloatValue * 10.0f) % 10.0f == 0.0f) {
                    canvas.drawText(String.valueOf(((int) fFloatValue) + this.N), fMeasureText, lineTop, this.H);
                } else {
                    canvas.drawText(String.valueOf(fFloatValue + this.N), fMeasureText, lineTop, this.H);
                }
                canvas.drawText(string2, ((f - fMeasureText) / 2.0f) + fMeasureText, this.K.v - this.R, paint);
                i++;
                f = fMeasureText;
            }
            CharSequence[] charSequenceArr3 = this.Q;
            canvas.drawText(charSequenceArr3[charSequenceArr3.length - 1].toString(), f + ((getLineRight() - f) / 2.0f), this.K.v - this.R, paint);
        }
        this.H.setColor(this.l);
        RectF rectF = this.I;
        float f5 = this.j;
        canvas.drawRoundRect(rectF, f5, f5, this.H);
        this.H.setColor(this.k);
        if (this.a == 2) {
            this.J.top = getLineTop();
            RectF rectF2 = this.J;
            a aVar = this.K;
            rectF2.left = aVar.t + (aVar.k() / 2) + (this.r * this.K.x);
            RectF rectF3 = this.J;
            a aVar2 = this.L;
            rectF3.right = aVar2.t + (aVar2.k() / 2) + (this.r * this.L.x);
            this.J.bottom = getLineBottom();
            RectF rectF4 = this.J;
            float f6 = this.j;
            canvas.drawRoundRect(rectF4, f6, f6, this.H);
        } else {
            this.J.top = getLineTop();
            RectF rectF5 = this.J;
            a aVar3 = this.K;
            rectF5.left = aVar3.t + (aVar3.k() / 2);
            RectF rectF6 = this.J;
            a aVar4 = this.K;
            rectF6.right = aVar4.t + (aVar4.k() / 2) + (this.r * this.K.x);
            this.J.bottom = getLineBottom();
            RectF rectF7 = this.J;
            float f7 = this.j;
            canvas.drawRoundRect(rectF7, f7, f7, this.H);
        }
        if (this.K.i() == 3) {
            this.K.u(true);
        }
        this.K.c(canvas);
        a aVar5 = this.L;
        if (aVar5 != null) {
            if (aVar5.i() == 3) {
                this.L.u(true);
            }
            this.L.c(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int lineTop = (getLineTop() * 2) + this.m;
        if (mode == 1073741824) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        } else {
            iMakeMeasureSpec = mode == Integer.MIN_VALUE ? View.MeasureSpec.makeMeasureSpec(lineTop, Integer.MIN_VALUE) : View.MeasureSpec.makeMeasureSpec(lineTop, 1073741824);
        }
        super.onMeasure(i, iMakeMeasureSpec);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        i(savedState.a, savedState.b, savedState.c, savedState.d);
        j(savedState.e, savedState.f);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.p;
        savedState.b = this.f441q;
        savedState.c = this.n;
        savedState.d = this.c;
        b[] rangeSeekBarState = getRangeSeekBarState();
        savedState.e = rangeSeekBarState[0].b;
        savedState.f = rangeSeekBarState[1].b;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int iK = (this.K.k() / 2) + getPaddingLeft();
        this.u = iK;
        int paddingRight = (i - iK) - getPaddingRight();
        this.v = paddingRight;
        this.r = paddingRight - this.u;
        this.w = i - paddingRight;
        int height = getHeight() - getLineTop();
        this.s = height;
        this.t = height + this.m;
        this.I.set(getLineLeft(), getLineTop(), getLineRight(), getLineBottom());
        this.K.p(getLineLeft(), getLineBottom(), this.r);
        a aVar = this.L;
        if (aVar != null) {
            aVar.p(getLineLeft(), getLineBottom(), this.r);
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x024f  */
    /* JADX WARN: Code duplicated, block: B:75:0x011f  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float lineLeft;
        float f;
        if (!this.F) {
            return true;
        }
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.x = b(motionEvent);
            a aVar = this.L;
            if (aVar == null || aVar.x < 1.0f || !this.K.b(b(motionEvent), c(motionEvent))) {
                a aVar2 = this.L;
                if (aVar2 == null || !aVar2.b(b(motionEvent), c(motionEvent))) {
                    if (this.K.b(b(motionEvent), c(motionEvent))) {
                        this.M = this.K;
                        h();
                    }
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    a(true);
                    return z;
                }
                this.M = this.L;
                h();
            } else {
                this.M = this.K;
                h();
            }
            z = true;
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            a(true);
            return z;
        }
        if (action == 1) {
            a aVar3 = this.L;
            if (aVar3 != null) {
                aVar3.u(false);
            }
            this.K.u(false);
            this.M.o();
            g();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            a(false);
        } else if (action == 2) {
            float fB = b(motionEvent);
            a aVar4 = this.L;
            if (aVar4 != null && this.K.x == aVar4.x) {
                this.M.o();
                if (fB - this.x > 0.0f) {
                    a aVar5 = this.M;
                    a aVar6 = this.L;
                    if (aVar5 != aVar6) {
                        g();
                        this.M = this.L;
                        h();
                    } else {
                        this.M = aVar6;
                    }
                } else {
                    a aVar7 = this.M;
                    a aVar8 = this.K;
                    if (aVar7 != aVar8) {
                        g();
                        this.M = this.K;
                        h();
                    } else {
                        this.M = aVar8;
                    }
                }
            }
            this.x = fB;
            a aVar9 = this.M;
            float f2 = aVar9.y;
            aVar9.y = f2 >= 1.0f ? 1.0f : f2 + 0.1f;
            if (aVar9 == this.K) {
                if (this.c > 1) {
                    int iRound = Math.round((fB >= ((float) getLineLeft()) ? ((fB - getLineLeft()) * 1.0f) / this.r : 0.0f) / this.y);
                    a aVar10 = this.L;
                    int iRound2 = aVar10 != null ? Math.round(aVar10.x / this.y) : Math.round(1.0f / this.y);
                    float f3 = iRound;
                    float f4 = this.y;
                    while (true) {
                        f = f3 * f4;
                        if (iRound <= iRound2 - this.o || (iRound = iRound - 1) < 0) {
                            break;
                        }
                        f3 = iRound;
                        f4 = this.y;
                    }
                } else {
                    float lineLeft2 = fB >= ((float) getLineLeft()) ? ((fB - getLineLeft()) * 1.0f) / this.r : 0.0f;
                    a aVar11 = this.L;
                    if (aVar11 != null) {
                        float f5 = aVar11.x;
                        float f6 = this.z;
                        if (lineLeft2 > f5 - f6) {
                            f = f5 - f6;
                        } else {
                            f = lineLeft2;
                        }
                    } else {
                        float f7 = this.z;
                        if (lineLeft2 > 1.0f - f7) {
                            f = 1.0f - f7;
                        } else {
                            f = lineLeft2;
                        }
                    }
                }
                this.K.w(f);
                this.K.u(true);
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            } else if (aVar9 == this.L) {
                if (this.c > 1) {
                    int iRound3 = Math.round((fB <= ((float) getLineRight()) ? ((fB - getLineLeft()) * 1.0f) / this.r : 1.0f) / this.y);
                    int iRound4 = Math.round(this.K.x / this.y);
                    float f8 = iRound3;
                    float f9 = this.y;
                    while (true) {
                        lineLeft = f8 * f9;
                        if (iRound3 >= this.o + iRound4) {
                            break;
                        }
                        iRound3++;
                        f9 = iRound3;
                        if (f9 > this.f441q - this.p) {
                            break;
                        }
                        f8 = this.y;
                    }
                } else {
                    lineLeft = fB <= ((float) getLineRight()) ? ((fB - getLineLeft()) * 1.0f) / this.r : 1.0f;
                    float f10 = this.K.x;
                    float f11 = this.z;
                    if (lineLeft < f10 + f11) {
                        lineLeft = f10 + f11;
                    }
                }
                this.L.w(lineLeft);
                this.L.u(true);
            }
            invalidate();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            a(true);
        } else if (action == 3) {
            a aVar12 = this.L;
            if (aVar12 != null) {
                aVar12.u(false);
            }
            a aVar13 = this.M;
            if (aVar13 == this.K || aVar13 == this.L) {
                g();
            }
            this.K.u(false);
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            a(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.F = z;
    }

    public void setIndicatorText(String str) {
        a aVar = this.K;
        if (aVar != null) {
            aVar.r(str);
        }
        a aVar2 = this.L;
        if (aVar2 != null) {
            aVar2.r(str);
        }
    }

    public void setIndicatorTextDecimalFormat(String str) {
        a aVar = this.K;
        if (aVar != null) {
            aVar.s(str);
        }
        a aVar2 = this.L;
        if (aVar2 != null) {
            aVar2.s(str);
        }
    }

    public void setIndicatorTextStringFormat(String str) {
        a aVar = this.K;
        if (aVar != null) {
            aVar.t(str);
        }
        a aVar2 = this.L;
        if (aVar2 != null) {
            aVar2.t(str);
        }
    }

    public void setLineBottom(int i) {
        this.t = i;
    }

    public void setLineLeft(int i) {
        this.u = i;
    }

    public void setLineRight(int i) {
        this.v = i;
    }

    public void setLineTop(int i) {
        this.s = i;
    }

    public void setLineWidth(int i) {
        this.r = i;
    }

    public void setOnRangeChangedListener(xv1 xv1Var) {
    }

    public void setProgressColor(int i) {
        this.k = i;
    }

    public void setProgressDefaultColor(int i) {
        this.l = i;
    }

    public void setProgressHeight(int i) {
        this.m = i;
    }

    public void setProgressRadius(float f) {
        this.j = f;
    }

    public void setRangeInterval(float f) {
        this.n = f;
    }

    public void setSeekBarMode(int i) {
        this.a = i;
    }

    public void setStartValue(int i) {
        this.N = i;
    }

    public void setTickMarkGravity(int i) {
        this.f = i;
    }

    public void setTickMarkInRangeTextColor(int i) {
        this.h = i;
    }

    public void setTickMarkMode(int i) {
        this.b = i;
    }

    public void setTickMarkNumber(int i) {
        this.c = i;
    }

    public void setTickMarkTextArray(CharSequence[] charSequenceArr) {
        this.i = charSequenceArr;
    }

    public void setTickMarkTextColor(int i) {
        this.g = i;
    }

    public void setTickMarkTextMargin(int i) {
        this.d = i;
    }

    public void setTickMarkTextSize(int i) {
        this.e = i;
    }

    public void setTypeface(Typeface typeface) {
        this.H.setTypeface(typeface);
    }

    public void setValue(float f) {
        this.O = f;
        j(f - this.N, this.f441q);
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 1;
        this.F = false;
        this.G = false;
        this.H = new Paint();
        this.I = new RectF();
        this.J = new RectF();
        d(attributeSet);
        e();
        if (this.a == 2) {
            this.K = new a(this, attributeSet, true);
            this.L = new a(this, attributeSet, false);
        } else {
            this.K = new a(this, attributeSet, true);
            this.L = null;
        }
        i(this.p, this.f441q, this.n, this.c);
        f();
    }
}
