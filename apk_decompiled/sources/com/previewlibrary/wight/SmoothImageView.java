package com.previewlibrary.wight;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.previewlibrary.R$id;
import defpackage.c11;
import uk.co.senab2.photoview2.PhotoView;

/* JADX INFO: loaded from: classes.dex */
public class SmoothImageView extends PhotoView {
    private static int y = 400;
    private Status c;
    private Paint d;
    private Matrix e;
    private i f;
    private i g;
    private i h;
    private Rect i;
    private boolean j;
    private int k;
    private int l;
    private boolean m;
    ValueAnimator n;
    private float o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f308q;
    private boolean r;
    private boolean s;
    private int t;
    private g u;
    private h v;
    private i w;
    private j x;

    public enum Status {
        STATE_NORMAL,
        STATE_IN,
        STATE_OUT,
        STATE_MOVE
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        int a = 0;

        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int i = this.a;
            if (i != 0) {
                SmoothImageView.this.offsetTopAndBottom(iIntValue - i);
            }
            this.a = iIntValue;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        int a = 0;

        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int i = this.a;
            if (i != 0) {
                SmoothImageView.this.offsetLeftAndRight(iIntValue - i);
            }
            this.a = iIntValue;
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (SmoothImageView.this.u != null) {
                SmoothImageView.this.u.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SmoothImageView.this.setScaleX(fFloatValue);
            SmoothImageView.this.setScaleY(fFloatValue);
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmoothImageView.this.h.e = ((Integer) valueAnimator.getAnimatedValue("animAlpha")).intValue();
            SmoothImageView.this.h.f = ((Float) valueAnimator.getAnimatedValue("animScale")).floatValue();
            SmoothImageView.this.h.a = ((Float) valueAnimator.getAnimatedValue("animLeft")).floatValue();
            SmoothImageView.this.h.b = ((Float) valueAnimator.getAnimatedValue("animTop")).floatValue();
            SmoothImageView.this.h.c = ((Float) valueAnimator.getAnimatedValue("animWidth")).floatValue();
            SmoothImageView.this.h.d = ((Float) valueAnimator.getAnimatedValue("animHeight")).floatValue();
            SmoothImageView.this.invalidate();
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (SmoothImageView.this.x != null) {
                SmoothImageView.this.x.a(SmoothImageView.this.c);
            }
            if (SmoothImageView.this.c == Status.STATE_IN) {
                SmoothImageView.this.c = Status.STATE_NORMAL;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SmoothImageView smoothImageView = SmoothImageView.this;
            int i = R$id.item_image_key;
            if (smoothImageView.getTag(i) != null) {
                SmoothImageView.this.setTag(i, null);
                SmoothImageView.this.setOnLongClickListener(null);
            }
        }
    }

    public interface g {
        void a(int i);
    }

    public interface h {
        void a();
    }

    private class i implements Cloneable {
        float a;
        float b;
        float c;
        float d;
        int e;
        float f;

        private i() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i clone() {
            try {
                return (i) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* synthetic */ i(SmoothImageView smoothImageView, a aVar) {
            this();
        }
    }

    public interface j {
        void a(Status status);
    }

    public SmoothImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = Status.STATE_NORMAL;
        this.o = 0.5f;
        this.r = false;
        this.s = false;
        this.t = 0;
        j();
    }

    private void h() {
        i iVar = this.w;
        if (iVar != null) {
            i iVarClone = iVar.clone();
            iVarClone.b = this.w.b + getTop();
            iVarClone.a = this.w.a + getLeft();
            iVarClone.e = this.t;
            iVarClone.f = this.w.f - ((1.0f - getScaleX()) * this.w.f);
            this.h = iVarClone.clone();
            this.g = iVarClone.clone();
        }
    }

    private void j() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.d.setColor(-16777216);
        this.e = new Matrix();
        setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private void k() {
        if (getDrawable() == null) {
            return;
        }
        if ((this.f != null && this.g != null && this.h != null) || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (getDrawable() instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) getDrawable()).getBitmap();
            this.k = bitmap.getWidth();
            this.l = bitmap.getHeight();
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight(), Bitmap.Config.RGB_565);
            this.k = bitmapCreateBitmap.getWidth();
            this.l = bitmapCreateBitmap.getHeight();
        }
        a aVar = null;
        i iVar = new i(this, aVar);
        this.f = iVar;
        iVar.e = 0;
        if (this.i == null) {
            this.i = new Rect();
        }
        i iVar2 = this.f;
        Rect rect = this.i;
        iVar2.a = rect.left;
        iVar2.b = rect.top - c11.a(getContext().getApplicationContext());
        this.f.c = this.i.width();
        this.f.d = this.i.height();
        float fWidth = this.i.width() / this.k;
        float fHeight = this.i.height() / this.l;
        i iVar3 = this.f;
        if (fWidth <= fHeight) {
            fWidth = fHeight;
        }
        iVar3.f = fWidth;
        float width = getWidth() / this.k;
        float height = getHeight() / this.l;
        i iVar4 = new i(this, aVar);
        this.g = iVar4;
        if (width >= height) {
            width = height;
        }
        iVar4.f = width;
        iVar4.e = 255;
        int i2 = (int) (this.k * width);
        int i3 = (int) (width * this.l);
        iVar4.a = (getWidth() - i2) / 2;
        this.g.b = (getHeight() - i3) / 2;
        i iVar5 = this.g;
        iVar5.c = i2;
        iVar5.d = i3;
        Status status = this.c;
        if (status == Status.STATE_IN) {
            this.h = this.f.clone();
        } else if (status == Status.STATE_OUT) {
            this.h = iVar5.clone();
        }
        this.w = this.g;
    }

    private float l() {
        if (this.w == null) {
            k();
        }
        return Math.abs(getTop() / this.w.d);
    }

    private void m() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getTop(), 0);
        valueAnimatorOfInt.addUpdateListener(new a());
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(getLeft(), 0);
        valueAnimatorOfInt2.addUpdateListener(new b());
        ValueAnimator valueAnimatorOfInt3 = ValueAnimator.ofInt(this.t, 255);
        valueAnimatorOfInt3.addUpdateListener(new c());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getScaleX(), 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new d());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(y);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(valueAnimatorOfInt, valueAnimatorOfInt2, valueAnimatorOfFloat, valueAnimatorOfInt3);
        animatorSet.start();
    }

    private void o() {
        this.j = false;
        if (this.h == null) {
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.n = valueAnimator;
        valueAnimator.setDuration(y);
        this.n.setInterpolator(new AccelerateDecelerateInterpolator());
        Status status = this.c;
        if (status == Status.STATE_IN) {
            this.n.setValues(PropertyValuesHolder.ofFloat("animScale", this.f.f, this.g.f), PropertyValuesHolder.ofInt("animAlpha", this.f.e, this.g.e), PropertyValuesHolder.ofFloat("animLeft", this.f.a, this.g.a), PropertyValuesHolder.ofFloat("animTop", this.f.b, this.g.b), PropertyValuesHolder.ofFloat("animWidth", this.f.c, this.g.c), PropertyValuesHolder.ofFloat("animHeight", this.f.d, this.g.d));
        } else if (status == Status.STATE_OUT) {
            this.n.setValues(PropertyValuesHolder.ofFloat("animScale", this.g.f, this.f.f), PropertyValuesHolder.ofInt("animAlpha", this.g.e, this.f.e), PropertyValuesHolder.ofFloat("animLeft", this.g.a, this.f.a), PropertyValuesHolder.ofFloat("animTop", this.g.b, this.f.b), PropertyValuesHolder.ofFloat("animWidth", this.g.c, this.f.c), PropertyValuesHolder.ofFloat("animHeight", this.g.d, this.f.d));
        }
        this.n.addUpdateListener(new e());
        this.n.addListener(new f());
        this.n.start();
    }

    public static void setDuration(int i2) {
        y = i2;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x009a  */
    /* JADX WARN: Code duplicated, block: B:39:0x009e  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ba  */
    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        h hVar;
        int action = motionEvent.getAction();
        if (getScale() == 1.0f) {
            if (action == 0) {
                this.p = (int) motionEvent.getX();
                this.f308q = (int) motionEvent.getY();
                if (this.w == null) {
                    k();
                }
                this.s = false;
                i iVar = this.w;
                if (iVar != null) {
                    float f2 = iVar.b;
                    int i2 = (int) f2;
                    int i3 = (int) (iVar.d + f2);
                    int i4 = this.f308q;
                    if (i4 >= i2 && i3 >= i4) {
                        this.s = true;
                    }
                }
                this.r = false;
            } else if (action == 1) {
                if (this.r) {
                    if (l() <= this.o) {
                        m();
                    } else {
                        h();
                        setTag(R$id.item_image_key, Boolean.TRUE);
                        hVar = this.v;
                        if (hVar != null) {
                            hVar.a();
                        }
                    }
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (this.r) {
                        if (l() <= this.o) {
                            m();
                        } else {
                            h();
                            setTag(R$id.item_image_key, Boolean.TRUE);
                            hVar = this.v;
                            if (hVar != null) {
                                hVar.a();
                            }
                        }
                        return true;
                    }
                }
            } else if (this.s || motionEvent.getPointerCount() != 1) {
                int x = (int) motionEvent.getX();
                int y2 = (int) motionEvent.getY();
                int i5 = x - this.p;
                int i6 = y2 - this.f308q;
                if (!this.r && (Math.abs(i5) > Math.abs(i6) || Math.abs(i6) < 5)) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (this.m) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (motionEvent.getPointerCount() == 1) {
                    this.c = Status.STATE_MOVE;
                    offsetLeftAndRight(i5);
                    offsetTopAndBottom(i6);
                    float fL = l();
                    float f3 = 1.0f - (0.1f * fL);
                    setScaleY(f3);
                    setScaleX(f3);
                    this.r = true;
                    this.t = (int) ((1.0f - (fL * 0.5f)) * 255.0f);
                    invalidate();
                    if (this.t < 0) {
                        this.t = 0;
                    }
                    g gVar = this.u;
                    if (gVar != null) {
                        gVar.a(this.t);
                    }
                    return true;
                }
            }
        } else if ((action == 1 || action == 3) && this.r) {
            if (l() <= this.o) {
                m();
            } else {
                h();
                setTag(R$id.item_image_key, Boolean.TRUE);
                h hVar2 = this.v;
                if (hVar2 != null) {
                    hVar2.a();
                }
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean i() {
        if (getScale() == 1.0f) {
            return true;
        }
        b(1.0f, true);
        return false;
    }

    public void n(boolean z, float f2) {
        this.m = z;
        this.o = f2;
    }

    @Override // uk.co.senab2.photoview2.PhotoView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k = 0;
        this.l = 0;
        this.i = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.n.clone();
            this.n = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        Status status = this.c;
        if (status != Status.STATE_OUT && status != Status.STATE_IN) {
            if (status == Status.STATE_MOVE) {
                this.d.setAlpha(0);
                canvas.drawPaint(this.d);
                super.onDraw(canvas);
                return;
            } else {
                this.d.setAlpha(255);
                canvas.drawPaint(this.d);
                super.onDraw(canvas);
                return;
            }
        }
        if (this.f == null || this.g == null || this.h == null) {
            k();
        }
        i iVar = this.h;
        if (iVar == null) {
            super.onDraw(canvas);
            return;
        }
        this.d.setAlpha(iVar.e);
        canvas.drawPaint(this.d);
        int saveCount = canvas.getSaveCount();
        Matrix matrix = this.e;
        float f2 = this.h.f;
        matrix.setScale(f2, f2);
        float f3 = this.k;
        i iVar2 = this.h;
        float f4 = iVar2.f;
        this.e.postTranslate((-((f3 * f4) - iVar2.c)) / 2.0f, (-((this.l * f4) - iVar2.d)) / 2.0f);
        i iVar3 = this.h;
        canvas.translate(iVar3.a, iVar3.b);
        i iVar4 = this.h;
        canvas.clipRect(0.0f, 0.0f, iVar4.c, iVar4.d);
        canvas.concat(this.e);
        getDrawable().draw(canvas);
        canvas.restoreToCount(saveCount);
        if (this.j) {
            o();
        }
    }

    public void p(j jVar) {
        setOnTransformListener(jVar);
        this.j = true;
        this.c = Status.STATE_IN;
        invalidate();
    }

    public void q(j jVar) {
        if (getTop() != 0) {
            offsetTopAndBottom(-getTop());
        }
        if (getLeft() != 0) {
            offsetLeftAndRight(-getLeft());
        }
        if (getScaleX() != 1.0f) {
            setScaleX(1.0f);
            setScaleY(1.0f);
        }
        setOnTransformListener(jVar);
        this.j = true;
        this.c = Status.STATE_OUT;
        invalidate();
    }

    public void setAlphaChangeListener(g gVar) {
        this.u = gVar;
    }

    public void setOnTransformListener(j jVar) {
        this.x = jVar;
    }

    public void setThumbRect(Rect rect) {
        this.i = rect;
    }

    public void setTransformOutListener(h hVar) {
        this.v = hVar;
    }

    public SmoothImageView(Context context) {
        super(context);
        this.c = Status.STATE_NORMAL;
        this.o = 0.5f;
        this.r = false;
        this.s = false;
        this.t = 0;
        j();
    }
}
