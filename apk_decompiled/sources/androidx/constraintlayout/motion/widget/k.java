package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import com.jieli.jl_rcsp.constant.WatchConstant;
import defpackage.d70;
import defpackage.x81;
import defpackage.ye0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private static String w = "ViewTransition";
    private int a;
    int e;
    c f;
    androidx.constraintlayout.widget.b.a g;
    private int j;
    private String k;
    Context o;
    private int b = -1;
    private boolean c = false;
    private int d = 0;
    private int h = -1;
    private int i = -1;
    private int l = 0;
    private String m = null;
    private int n = -1;
    private int p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f180q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;

    class a implements Interpolator {
        final /* synthetic */ ye0 a;

        a(k kVar, ye0 ye0Var) {
            this.a = ye0Var;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.a.a(f);
        }
    }

    static class b {
        private final int a;
        private final int b;
        long c;
        g d;
        int e;
        int f;
        l h;
        Interpolator i;
        float k;
        float l;
        long m;
        boolean o;
        x81 g = new x81();
        boolean j = false;
        Rect n = new Rect();

        b(l lVar, g gVar, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
            this.o = false;
            this.h = lVar;
            this.d = gVar;
            this.e = i;
            this.f = i2;
            long jNanoTime = System.nanoTime();
            this.c = jNanoTime;
            this.m = jNanoTime;
            this.h.b(this);
            this.i = interpolator;
            this.a = i4;
            this.b = i5;
            if (i3 == 3) {
                this.o = true;
            }
            this.l = i == 0 ? Float.MAX_VALUE : 1.0f / i;
            a();
        }

        void a() {
            if (this.j) {
                c();
            } else {
                b();
            }
        }

        void b() {
            long jNanoTime = System.nanoTime();
            long j = jNanoTime - this.m;
            this.m = jNanoTime;
            float f = this.k + (((float) (j * 1.0E-6d)) * this.l);
            this.k = f;
            if (f >= 1.0f) {
                this.k = 1.0f;
            }
            Interpolator interpolator = this.i;
            float interpolation = interpolator == null ? this.k : interpolator.getInterpolation(this.k);
            g gVar = this.d;
            boolean zX = gVar.x(gVar.b, interpolation, jNanoTime, this.g);
            if (this.k >= 1.0f) {
                if (this.a != -1) {
                    this.d.v().setTag(this.a, Long.valueOf(System.nanoTime()));
                }
                if (this.b != -1) {
                    this.d.v().setTag(this.b, null);
                }
                if (!this.o) {
                    this.h.g(this);
                }
            }
            if (this.k < 1.0f || zX) {
                this.h.e();
            }
        }

        void c() {
            long jNanoTime = System.nanoTime();
            long j = jNanoTime - this.m;
            this.m = jNanoTime;
            float f = this.k - (((float) (j * 1.0E-6d)) * this.l);
            this.k = f;
            if (f < 0.0f) {
                this.k = 0.0f;
            }
            Interpolator interpolator = this.i;
            float interpolation = interpolator == null ? this.k : interpolator.getInterpolation(this.k);
            g gVar = this.d;
            boolean zX = gVar.x(gVar.b, interpolation, jNanoTime, this.g);
            if (this.k <= 0.0f) {
                if (this.a != -1) {
                    this.d.v().setTag(this.a, Long.valueOf(System.nanoTime()));
                }
                if (this.b != -1) {
                    this.d.v().setTag(this.b, null);
                }
                this.h.g(this);
            }
            if (this.k > 0.0f || zX) {
                this.h.e();
            }
        }

        public void d(int i, float f, float f2) {
            if (i == 1) {
                if (this.j) {
                    return;
                }
                e(true);
            } else {
                if (i != 2) {
                    return;
                }
                this.d.v().getHitRect(this.n);
                if (this.n.contains((int) f, (int) f2) || this.j) {
                    return;
                }
                e(true);
            }
        }

        void e(boolean z) {
            int i;
            this.j = z;
            if (z && (i = this.f) != -1) {
                this.l = i == 0 ? Float.MAX_VALUE : 1.0f / i;
            }
            this.h.e();
            this.m = System.nanoTime();
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    k(Context context, XmlPullParser xmlPullParser) {
        byte b2;
        this.o = context;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (!name.equals("ConstraintOverride")) {
                                b2 = -1;
                            } else {
                                b2 = 2;
                            }
                            break;
                        case -1239391468:
                            if (!name.equals("KeyFrameSet")) {
                                b2 = -1;
                            } else {
                                b2 = 1;
                            }
                            break;
                        case 61998586:
                            if (!name.equals("ViewTransition")) {
                                b2 = -1;
                            } else {
                                b2 = 0;
                            }
                            break;
                        case 366511058:
                            if (!name.equals("CustomMethod")) {
                                b2 = -1;
                            } else {
                                b2 = 4;
                            }
                            break;
                        case 1791837707:
                            if (!name.equals("CustomAttribute")) {
                                b2 = -1;
                            } else {
                                b2 = 3;
                            }
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    if (b2 == 0) {
                        l(context, xmlPullParser);
                    } else if (b2 == 1) {
                        this.f = new c(context, xmlPullParser);
                    } else if (b2 == 2) {
                        this.g = androidx.constraintlayout.widget.b.m(context, xmlPullParser);
                    } else if (b2 == 3 || b2 == 4) {
                        ConstraintAttribute.h(context, xmlPullParser, this.g.g);
                    } else {
                        Log.e(w, d70.a() + " unknown tag " + name);
                        Log.e(w, ".xml:" + xmlPullParser.getLineNumber());
                    }
                } else if (eventType == 3 && "ViewTransition".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View[] viewArr) {
        if (this.p != -1) {
            for (View view : viewArr) {
                view.setTag(this.p, Long.valueOf(System.nanoTime()));
            }
        }
        if (this.f180q != -1) {
            for (View view2 : viewArr) {
                view2.setTag(this.f180q, null);
            }
        }
    }

    private void l(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.ViewTransition);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R$styleable.ViewTransition_android_id) {
                this.a = typedArrayObtainStyledAttributes.getResourceId(index, this.a);
            } else if (index == R$styleable.ViewTransition_motionTarget) {
                if (MotionLayout.h1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                    this.j = resourceId;
                    if (resourceId == -1) {
                        this.k = typedArrayObtainStyledAttributes.getString(index);
                    }
                } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                    this.k = typedArrayObtainStyledAttributes.getString(index);
                } else {
                    this.j = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                }
            } else if (index == R$styleable.ViewTransition_onStateTransition) {
                this.b = typedArrayObtainStyledAttributes.getInt(index, this.b);
            } else if (index == R$styleable.ViewTransition_transitionDisable) {
                this.c = typedArrayObtainStyledAttributes.getBoolean(index, this.c);
            } else if (index == R$styleable.ViewTransition_pathMotionArc) {
                this.d = typedArrayObtainStyledAttributes.getInt(index, this.d);
            } else if (index == R$styleable.ViewTransition_duration) {
                this.h = typedArrayObtainStyledAttributes.getInt(index, this.h);
            } else if (index == R$styleable.ViewTransition_upDuration) {
                this.i = typedArrayObtainStyledAttributes.getInt(index, this.i);
            } else if (index == R$styleable.ViewTransition_viewTransitionMode) {
                this.e = typedArrayObtainStyledAttributes.getInt(index, this.e);
            } else if (index == R$styleable.ViewTransition_motionInterpolator) {
                int i2 = typedArrayObtainStyledAttributes.peekValue(index).type;
                if (i2 == 1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    this.n = resourceId2;
                    if (resourceId2 != -1) {
                        this.l = -2;
                    }
                } else if (i2 == 3) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.m = string;
                    if (string == null || string.indexOf(WatchConstant.FAT_FS_ROOT) <= 0) {
                        this.l = -1;
                    } else {
                        this.n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                        this.l = -2;
                    }
                } else {
                    this.l = typedArrayObtainStyledAttributes.getInteger(index, this.l);
                }
            } else if (index == R$styleable.ViewTransition_setsTag) {
                this.p = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
            } else if (index == R$styleable.ViewTransition_clearsTag) {
                this.f180q = typedArrayObtainStyledAttributes.getResourceId(index, this.f180q);
            } else if (index == R$styleable.ViewTransition_ifTagSet) {
                this.r = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
            } else if (index == R$styleable.ViewTransition_ifTagNotSet) {
                this.s = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
            } else if (index == R$styleable.ViewTransition_SharedValueId) {
                this.u = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
            } else if (index == R$styleable.ViewTransition_SharedValue) {
                this.t = typedArrayObtainStyledAttributes.getInteger(index, this.t);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void n(i.b bVar, View view) {
        int i = this.h;
        if (i != -1) {
            bVar.E(i);
        }
        bVar.H(this.d);
        bVar.F(this.l, this.m, this.n);
        int id = view.getId();
        c cVar = this.f;
        if (cVar != null) {
            ArrayList arrayListD = cVar.d(-1);
            c cVar2 = new c();
            Iterator it = arrayListD.iterator();
            while (it.hasNext()) {
                cVar2.c(((androidx.constraintlayout.motion.widget.a) it.next()).clone().i(id));
            }
            bVar.t(cVar2);
        }
    }

    void b(l lVar, MotionLayout motionLayout, View view) {
        g gVar = new g(view);
        gVar.B(view);
        this.f.a(gVar);
        gVar.I(motionLayout.getWidth(), motionLayout.getHeight(), this.h, System.nanoTime());
        new b(lVar, gVar, this.h, this.i, this.b, f(motionLayout.getContext()), this.p, this.f180q);
    }

    void c(l lVar, MotionLayout motionLayout, int i, androidx.constraintlayout.widget.b bVar, final View... viewArr) {
        if (this.c) {
            return;
        }
        int i2 = this.e;
        if (i2 == 2) {
            b(lVar, motionLayout, viewArr[0]);
            return;
        }
        if (i2 == 1) {
            for (int i3 : motionLayout.getConstraintSetIds()) {
                if (i3 != i) {
                    androidx.constraintlayout.widget.b bVarL0 = motionLayout.l0(i3);
                    for (View view : viewArr) {
                        androidx.constraintlayout.widget.b.a aVarV = bVarL0.v(view.getId());
                        androidx.constraintlayout.widget.b.a aVar = this.g;
                        if (aVar != null) {
                            aVar.d(aVarV);
                            aVarV.g.putAll(this.g.g);
                        }
                    }
                }
            }
        }
        androidx.constraintlayout.widget.b bVar2 = new androidx.constraintlayout.widget.b();
        bVar2.p(bVar);
        for (View view2 : viewArr) {
            androidx.constraintlayout.widget.b.a aVarV2 = bVar2.v(view2.getId());
            androidx.constraintlayout.widget.b.a aVar2 = this.g;
            if (aVar2 != null) {
                aVar2.d(aVarV2);
                aVarV2.g.putAll(this.g.g);
            }
        }
        motionLayout.J0(i, bVar2);
        int i4 = R$id.view_transition;
        motionLayout.J0(i4, bVar);
        motionLayout.x0(i4, -1, -1);
        i.b bVar3 = new i.b(-1, motionLayout.y, i4, i);
        for (View view3 : viewArr) {
            n(bVar3, view3);
        }
        motionLayout.setTransition(bVar3);
        motionLayout.D0(new Runnable() { // from class: gf3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.j(viewArr);
            }
        });
    }

    boolean d(View view) {
        int i = this.r;
        boolean z = i == -1 || view.getTag(i) != null;
        int i2 = this.s;
        return z && (i2 == -1 || view.getTag(i2) == null);
    }

    int e() {
        return this.a;
    }

    Interpolator f(Context context) {
        int i = this.l;
        if (i == -2) {
            return AnimationUtils.loadInterpolator(context, this.n);
        }
        if (i == -1) {
            return new a(this, ye0.c(this.m));
        }
        if (i == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i == 1) {
            return new AccelerateInterpolator();
        }
        if (i == 2) {
            return new DecelerateInterpolator();
        }
        if (i == 4) {
            return new BounceInterpolator();
        }
        if (i == 5) {
            return new OvershootInterpolator();
        }
        if (i != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public int g() {
        return this.t;
    }

    public int h() {
        return this.u;
    }

    public int i() {
        return this.b;
    }

    boolean k(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.j == -1 && this.k == null) || !d(view)) {
            return false;
        }
        if (view.getId() == this.j) {
            return true;
        }
        return this.k != null && (view.getLayoutParams() instanceof ConstraintLayout.b) && (str = ((ConstraintLayout.b) view.getLayoutParams()).c0) != null && str.matches(this.k);
    }

    boolean m(int i) {
        int i2 = this.b;
        if (i2 == 1) {
            return i == 0;
        }
        if (i2 == 2) {
            return i == 1;
        }
        return i2 == 3 && i == 0;
    }

    public String toString() {
        return "ViewTransition(" + d70.c(this.o, this.a) + ")";
    }
}
