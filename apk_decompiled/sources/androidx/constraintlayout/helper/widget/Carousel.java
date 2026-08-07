package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.i;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Carousel extends MotionHelper {
    private int F;
    private float G;
    private int H;
    private int I;
    int J;
    Runnable K;
    private final ArrayList n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MotionLayout f167q;
    private int r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float x;
    private int y;
    private int z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Carousel.this.f167q.setProgress(0.0f);
            Carousel.this.J();
            Carousel.H(Carousel.this);
            int unused = Carousel.this.p;
            throw null;
        }
    }

    public interface b {
    }

    public Carousel(Context context) {
        super(context);
        this.n = new ArrayList();
        this.o = 0;
        this.p = 0;
        this.r = -1;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = 0.9f;
        this.y = 0;
        this.z = 4;
        this.F = 1;
        this.G = 2.0f;
        this.H = -1;
        this.I = 200;
        this.J = -1;
        this.K = new a();
    }

    static /* synthetic */ b H(Carousel carousel) {
        carousel.getClass();
        return null;
    }

    private void I(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.Carousel_carousel_firstView) {
                    this.r = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
                } else if (index == R$styleable.Carousel_carousel_backwardTransition) {
                    this.t = typedArrayObtainStyledAttributes.getResourceId(index, this.t);
                } else if (index == R$styleable.Carousel_carousel_forwardTransition) {
                    this.u = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
                } else if (index == R$styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.z = typedArrayObtainStyledAttributes.getInt(index, this.z);
                } else if (index == R$styleable.Carousel_carousel_previousState) {
                    this.v = typedArrayObtainStyledAttributes.getResourceId(index, this.v);
                } else if (index == R$styleable.Carousel_carousel_nextState) {
                    this.w = typedArrayObtainStyledAttributes.getResourceId(index, this.w);
                } else if (index == R$styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.x = typedArrayObtainStyledAttributes.getFloat(index, this.x);
                } else if (index == R$styleable.Carousel_carousel_touchUpMode) {
                    this.F = typedArrayObtainStyledAttributes.getInt(index, this.F);
                } else if (index == R$styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.G = typedArrayObtainStyledAttributes.getFloat(index, this.G);
                } else if (index == R$styleable.Carousel_carousel_infinite) {
                    this.s = typedArrayObtainStyledAttributes.getBoolean(index, this.s);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.j
    public void a(MotionLayout motionLayout, int i, int i2, float f) {
        this.J = i;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.j
    public void c(MotionLayout motionLayout, int i) {
        int i2 = this.p;
        this.o = i2;
        if (i == this.w) {
            this.p = i2 + 1;
        } else if (i == this.v) {
            this.p = i2 - 1;
        }
        if (!this.s) {
            throw null;
        }
        throw null;
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.p;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i = 0; i < this.b; i++) {
                int i2 = this.a[i];
                View viewI = motionLayout.i(i2);
                if (this.r == i2) {
                    this.y = i;
                }
                this.n.add(viewI);
            }
            this.f167q = motionLayout;
            if (this.F == 2) {
                i.b bVarN0 = motionLayout.n0(this.u);
                if (bVarN0 != null) {
                    bVarN0.G(5);
                }
                i.b bVarN1 = this.f167q.n0(this.t);
                if (bVarN1 != null) {
                    bVarN1.G(5);
                }
            }
            J();
        }
    }

    public void setAdapter(b bVar) {
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new ArrayList();
        this.o = 0;
        this.p = 0;
        this.r = -1;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = 0.9f;
        this.y = 0;
        this.z = 4;
        this.F = 1;
        this.G = 2.0f;
        this.H = -1;
        this.I = 200;
        this.J = -1;
        this.K = new a();
        I(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new ArrayList();
        this.o = 0;
        this.p = 0;
        this.r = -1;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = 0.9f;
        this.y = 0;
        this.z = 4;
        this.F = 1;
        this.G = 2.0f;
        this.H = -1;
        this.I = 200;
        this.J = -1;
        this.K = new a();
        I(context, attributeSet);
    }
}
