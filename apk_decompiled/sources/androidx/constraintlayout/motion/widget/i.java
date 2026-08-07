package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import defpackage.d70;
import defpackage.st2;
import defpackage.ye0;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private final MotionLayout a;
    private MotionEvent n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MotionLayout.g f177q;
    private boolean r;
    final l s;
    float t;
    float u;
    st2 b = null;
    b c = null;
    private boolean d = false;
    private ArrayList e = new ArrayList();
    private b f = null;
    private ArrayList g = new ArrayList();
    private SparseArray h = new SparseArray();
    private HashMap i = new HashMap();
    private SparseIntArray j = new SparseIntArray();
    private boolean k = false;
    private int l = 400;
    private int m = 0;
    private boolean o = false;
    private boolean p = false;

    class a implements Interpolator {
        final /* synthetic */ ye0 a;

        a(i iVar, ye0 ye0Var) {
            this.a = ye0Var;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) this.a.a(f);
        }
    }

    i(Context context, MotionLayout motionLayout, int i) {
        this.a = motionLayout;
        this.s = new l(motionLayout);
        K(context, i);
        SparseArray sparseArray = this.h;
        int i2 = R$id.motion_base;
        sparseArray.put(i2, new androidx.constraintlayout.widget.b());
        this.i.put("motion_base", Integer.valueOf(i2));
    }

    private boolean I(int i) {
        int i2 = this.j.get(i);
        int size = this.j.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.j.get(i2);
            size = i3;
        }
        return false;
    }

    private boolean J() {
        return this.f177q != null;
    }

    private void K(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            int eventType = xml.getEventType();
            b bVar = null;
            while (true) {
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.k) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name) {
                        case "MotionScene":
                            O(context, xml);
                            break;
                        case "Transition":
                            ArrayList arrayList = this.e;
                            bVar = new b(this, context, xml);
                            arrayList.add(bVar);
                            if (this.c == null && !bVar.b) {
                                this.c = bVar;
                                if (bVar.l != null) {
                                    this.c.l.x(this.r);
                                }
                            }
                            if (!bVar.b) {
                                break;
                            } else {
                                if (bVar.c == -1) {
                                    this.f = bVar;
                                } else {
                                    this.g.add(bVar);
                                }
                                this.e.remove(bVar);
                                break;
                            }
                            break;
                        case "OnSwipe":
                            if (bVar == null) {
                                Log.v("MotionScene", " OnSwipe (" + context.getResources().getResourceEntryName(i) + ".xml:" + xml.getLineNumber() + ")");
                            }
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.l = new j(context, this.a, xml);
                                break;
                            }
                            break;
                        case "OnClick":
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.u(context, xml);
                                break;
                            }
                            break;
                        case "StateSet":
                            this.b = new st2(context, xml);
                            break;
                        case "ConstraintSet":
                            L(context, xml);
                            break;
                        case "include":
                        case "Include":
                            N(context, xml);
                            break;
                        case "KeyFrameSet":
                            c cVar = new c(context, xml);
                            if (bVar == null) {
                                break;
                            } else {
                                bVar.k.add(cVar);
                                break;
                            }
                            break;
                        case "ViewTransition":
                            this.s.a(new k(context, xml));
                            break;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x0098  */
    /* JADX WARN: Code duplicated, block: B:9:0x0046  */
    private int L(Context context, XmlPullParser xmlPullParser) {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.Q(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int iR = -1;
        int iR2 = -1;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (this.k) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            switch (attributeName) {
                case "deriveConstraintsFrom":
                    iR2 = r(context, attributeValue);
                    break;
                case "constraintRotate":
                    try {
                        bVar.d = Integer.parseInt(attributeValue);
                        break;
                    } catch (NumberFormatException unused) {
                        attributeValue.hashCode();
                        switch (attributeValue) {
                            case "x_left":
                                bVar.d = 4;
                                break;
                            case "left":
                                bVar.d = 2;
                                break;
                            case "none":
                                bVar.d = 0;
                                break;
                            case "right":
                                bVar.d = 1;
                                break;
                            case "x_right":
                                bVar.d = 3;
                                break;
                        }
                        break;
                    }
                    break;
                case "id":
                    iR = r(context, attributeValue);
                    this.i.put(a0(attributeValue), Integer.valueOf(iR));
                    bVar.b = d70.c(context, iR);
                    break;
                default:
                    break;
            }
        }
        if (iR != -1) {
            if (this.a.d0 != 0) {
                bVar.R(true);
            }
            bVar.D(context, xmlPullParser);
            if (iR2 != -1) {
                this.j.put(iR, iR2);
            }
            this.h.put(iR, bVar);
        }
        return iR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int M(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return L(context, xml);
                }
            }
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private void N(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R$styleable.include_constraintSet) {
                M(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void O(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R$styleable.MotionScene_defaultDuration) {
                int i2 = typedArrayObtainStyledAttributes.getInt(index, this.l);
                this.l = i2;
                if (i2 < 8) {
                    this.l = 8;
                }
            } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                this.m = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void S(int i, MotionLayout motionLayout) {
        androidx.constraintlayout.widget.b bVar = (androidx.constraintlayout.widget.b) this.h.get(i);
        bVar.c = bVar.b;
        int i2 = this.j.get(i);
        if (i2 > 0) {
            S(i2, motionLayout);
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) this.h.get(i2);
            if (bVar2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + d70.c(this.a.getContext(), i2));
                return;
            }
            bVar.c += WatchConstant.FAT_FS_ROOT + bVar2.c;
            bVar.L(bVar2);
        } else {
            bVar.c += "  layout";
            bVar.K(motionLayout);
        }
        bVar.h(bVar);
    }

    public static String a0(String str) {
        if (str == null) {
            return Constants.STR_EMPTY;
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    private int r(Context context, String str) {
        int identifier;
        if (str.contains(WatchConstant.FAT_FS_ROOT)) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.k) {
                System.out.println("id getMap res = " + identifier);
            }
        } else {
            identifier = -1;
        }
        if (identifier != -1) {
            return identifier;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e("MotionScene", "error in parsing id");
        return identifier;
    }

    private int y(int i) {
        int iC;
        st2 st2Var = this.b;
        return (st2Var == null || (iC = st2Var.c(i, -1, -1)) == -1) ? i : iC;
    }

    float A() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.l();
    }

    float B() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.m();
    }

    float C() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.n();
    }

    float D() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.o();
    }

    public float E() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.i;
        }
        return 0.0f;
    }

    int F() {
        b bVar = this.c;
        if (bVar == null) {
            return -1;
        }
        return bVar.d;
    }

    public b G(int i) {
        for (b bVar : this.e) {
            if (bVar.a == i) {
                return bVar;
            }
        }
        return null;
    }

    public List H(int i) {
        int iY = y(i);
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.e) {
            if (bVar.d == iY || bVar.c == iY) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    void P(float f, float f2) {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.u(f, f2);
    }

    void Q(float f, float f2) {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.v(f, f2);
    }

    void R(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        MotionLayout.g gVar;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.f177q == null) {
            this.f177q = this.a.s0();
        }
        this.f177q.b(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.t = motionEvent.getRawX();
                this.u = motionEvent.getRawY();
                this.n = motionEvent;
                this.o = false;
                if (this.c.l != null) {
                    RectF rectFF = this.c.l.f(this.a, rectF);
                    if (rectFF != null && !rectFF.contains(this.n.getX(), this.n.getY())) {
                        this.n = null;
                        this.o = true;
                        return;
                    }
                    RectF rectFP = this.c.l.p(this.a, rectF);
                    if (rectFP == null || rectFP.contains(this.n.getX(), this.n.getY())) {
                        this.p = false;
                    } else {
                        this.p = true;
                    }
                    this.c.l.w(this.t, this.u);
                    return;
                }
                return;
            }
            if (action == 2 && !this.o) {
                float rawY = motionEvent.getRawY() - this.u;
                float rawX = motionEvent.getRawX() - this.t;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.n) == null) {
                    return;
                }
                b bVarI = i(i, rawX, rawY, motionEvent2);
                if (bVarI != null) {
                    motionLayout.setTransition(bVarI);
                    RectF rectFP2 = this.c.l.p(this.a, rectF);
                    if (rectFP2 != null && !rectFP2.contains(this.n.getX(), this.n.getY())) {
                        z = true;
                    }
                    this.p = z;
                    this.c.l.z(this.t, this.u);
                }
            }
        }
        if (this.o) {
            return;
        }
        b bVar = this.c;
        if (bVar != null && bVar.l != null && !this.p) {
            this.c.l.s(motionEvent, this.f177q, i, this);
        }
        this.t = motionEvent.getRawX();
        this.u = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (gVar = this.f177q) == null) {
            return;
        }
        gVar.a();
        this.f177q = null;
        int i2 = motionLayout.I;
        if (i2 != -1) {
            h(motionLayout, i2);
        }
    }

    void T(MotionLayout motionLayout) {
        for (int i = 0; i < this.h.size(); i++) {
            int iKeyAt = this.h.keyAt(i);
            if (I(iKeyAt)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            S(iKeyAt, motionLayout);
        }
    }

    public void U(int i, androidx.constraintlayout.widget.b bVar) {
        this.h.put(i, bVar);
    }

    public void V(int i) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.E(i);
        } else {
            this.l = i;
        }
    }

    public void W(boolean z) {
        this.r = z;
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.x(this.r);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0039  */
    /* JADX WARN: Code duplicated, block: B:40:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0096  */
    /* JADX WARN: Code duplicated, block: B:48:0x006d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0075 A[SYNTHETIC] */
    void X(int i, int i2) {
        int iC;
        int iC2;
        b bVar;
        Iterator it;
        b bVar2;
        b bVar3;
        b bVar4;
        st2 st2Var = this.b;
        if (st2Var != null) {
            iC = st2Var.c(i, -1, -1);
            if (iC == -1) {
                iC = i;
            }
            iC2 = this.b.c(i2, -1, -1);
            if (iC2 == -1) {
            }
            bVar = this.c;
            if (bVar == null && bVar.c == i2 && this.c.d == i) {
                return;
            }
            it = this.e.iterator();
            while (true) {
                if (it.hasNext()) {
                    bVar2 = this.f;
                    for (b bVar5 : this.g) {
                        if (bVar5.c == i2) {
                            bVar2 = bVar5;
                        }
                    }
                    bVar3 = new b(this, bVar2);
                    bVar3.d = iC;
                    bVar3.c = iC2;
                    if (iC != -1) {
                        this.e.add(bVar3);
                    }
                    this.c = bVar3;
                    return;
                }
                bVar4 = (b) it.next();
                if ((bVar4.c != iC2 && bVar4.d == iC) || (bVar4.c == i2 && bVar4.d == i)) {
                    break;
                }
            }
            this.c = bVar4;
            if (bVar4 != null || bVar4.l == null) {
            }
            this.c.l.x(this.r);
            return;
        }
        iC = i;
        iC2 = i2;
        bVar = this.c;
        if (bVar == null) {
        }
        it = this.e.iterator();
        while (true) {
            if (it.hasNext()) {
                bVar2 = this.f;
                while (r3.hasNext()) {
                    if (bVar5.c == i2) {
                        bVar2 = bVar5;
                    }
                }
                bVar3 = new b(this, bVar2);
                bVar3.d = iC;
                bVar3.c = iC2;
                if (iC != -1) {
                    this.e.add(bVar3);
                }
                this.c = bVar3;
                return;
            }
            bVar4 = (b) it.next();
            if (bVar4.c != iC2) {
            }
        }
        this.c = bVar4;
        if (bVar4 != null) {
        }
    }

    public void Y(b bVar) {
        this.c = bVar;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.x(this.r);
    }

    void Z() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return;
        }
        this.c.l.A();
    }

    boolean b0() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            if (((b) it.next()).l != null) {
                return true;
            }
        }
        b bVar = this.c;
        return (bVar == null || bVar.l == null) ? false : true;
    }

    public void f(MotionLayout motionLayout, int i) {
        for (b bVar : this.e) {
            if (bVar.m.size() > 0) {
                Iterator it = bVar.m.iterator();
                while (it.hasNext()) {
                    ((b.a) it.next()).c(motionLayout);
                }
            }
        }
        for (b bVar2 : this.g) {
            if (bVar2.m.size() > 0) {
                Iterator it2 = bVar2.m.iterator();
                while (it2.hasNext()) {
                    ((b.a) it2.next()).c(motionLayout);
                }
            }
        }
        for (b bVar3 : this.e) {
            if (bVar3.m.size() > 0) {
                Iterator it3 = bVar3.m.iterator();
                while (it3.hasNext()) {
                    ((b.a) it3.next()).a(motionLayout, i, bVar3);
                }
            }
        }
        for (b bVar4 : this.g) {
            if (bVar4.m.size() > 0) {
                Iterator it4 = bVar4.m.iterator();
                while (it4.hasNext()) {
                    ((b.a) it4.next()).a(motionLayout, i, bVar4);
                }
            }
        }
    }

    public boolean g(int i, g gVar) {
        return this.s.d(i, gVar);
    }

    boolean h(MotionLayout motionLayout, int i) {
        b bVar;
        if (J() || this.d) {
            return false;
        }
        for (b bVar2 : this.e) {
            if (bVar2.n != 0 && ((bVar = this.c) != bVar2 || !bVar.D(2))) {
                if (i == bVar2.d && (bVar2.n == 4 || bVar2.n == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.n == 4) {
                        motionLayout.C0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.g0(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.t0();
                    }
                    return true;
                }
                if (i == bVar2.c && (bVar2.n == 3 || bVar2.n == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(bVar2);
                    if (bVar2.n == 3) {
                        motionLayout.E0();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.g0(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.t0();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public b i(int i, float f, float f2, MotionEvent motionEvent) {
        if (i == -1) {
            return this.c;
        }
        List<b> listH = H(i);
        RectF rectF = new RectF();
        float f3 = 0.0f;
        b bVar = null;
        for (b bVar2 : listH) {
            if (!bVar2.o && bVar2.l != null) {
                bVar2.l.x(this.r);
                RectF rectFP = bVar2.l.p(this.a, rectF);
                if (rectFP == null || motionEvent == null || rectFP.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF rectFF = bVar2.l.f(this.a, rectF);
                    if (rectFF == null || motionEvent == null || rectFF.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fA = bVar2.l.a(f, f2);
                        if (bVar2.l.l && motionEvent != null) {
                            float x = motionEvent.getX() - bVar2.l.i;
                            float y = motionEvent.getY() - bVar2.l.j;
                            fA = ((float) (Math.atan2(f2 + y, f + x) - Math.atan2(x, y))) * 10.0f;
                        }
                        float f4 = fA * (bVar2.c == i ? -1.0f : 1.1f);
                        if (f4 > f3) {
                            bVar = bVar2;
                            f3 = f4;
                        }
                    }
                }
            }
        }
        return bVar;
    }

    public int j() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.p;
        }
        return -1;
    }

    int k() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0;
        }
        return this.c.l.d();
    }

    androidx.constraintlayout.widget.b l(int i) {
        return m(i, -1, -1);
    }

    androidx.constraintlayout.widget.b m(int i, int i2, int i3) {
        int iC;
        if (this.k) {
            PrintStream printStream = System.out;
            printStream.println("id " + i);
            printStream.println("size " + this.h.size());
        }
        st2 st2Var = this.b;
        if (st2Var != null && (iC = st2Var.c(i, i2, i3)) != -1) {
            i = iC;
        }
        if (this.h.get(i) != null) {
            return (androidx.constraintlayout.widget.b) this.h.get(i);
        }
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + d70.c(this.a.getContext(), i) + " In MotionScene");
        SparseArray sparseArray = this.h;
        return (androidx.constraintlayout.widget.b) sparseArray.get(sparseArray.keyAt(0));
    }

    public int[] n() {
        int size = this.h.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.h.keyAt(i);
        }
        return iArr;
    }

    public ArrayList o() {
        return this.e;
    }

    public int p() {
        b bVar = this.c;
        return bVar != null ? bVar.h : this.l;
    }

    int q() {
        b bVar = this.c;
        if (bVar == null) {
            return -1;
        }
        return bVar.c;
    }

    public Interpolator s() {
        int i = this.c.e;
        if (i == -2) {
            return AnimationUtils.loadInterpolator(this.a.getContext(), this.c.g);
        }
        if (i == -1) {
            return new a(this, ye0.c(this.c.f));
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

    public void t(g gVar) {
        b bVar = this.c;
        if (bVar != null) {
            Iterator it = bVar.k.iterator();
            while (it.hasNext()) {
                ((c) it.next()).b(gVar);
            }
        } else {
            b bVar2 = this.f;
            if (bVar2 != null) {
                Iterator it2 = bVar2.k.iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).b(gVar);
                }
            }
        }
    }

    float u() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.g();
    }

    float v() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.h();
    }

    boolean w() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return false;
        }
        return this.c.l.i();
    }

    float x(float f, float f2) {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0.0f;
        }
        return this.c.l.j(f, f2);
    }

    int z() {
        b bVar = this.c;
        if (bVar == null || bVar.l == null) {
            return 0;
        }
        return this.c.l.k();
    }

    public static class b {
        private int a;
        private boolean b;
        private int c;
        private int d;
        private int e;
        private String f;
        private int g;
        private int h;
        private float i;
        private final i j;
        private ArrayList k;
        private j l;
        private ArrayList m;
        private int n;
        private boolean o;
        private int p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f178q;
        private int r;

        public static class a implements View.OnClickListener {
            private final b a;
            int b;
            int c;

            public a(Context context, b bVar, XmlPullParser xmlPullParser) {
                this.b = -1;
                this.c = 17;
                this.a = bVar;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i);
                    if (index == R$styleable.OnClick_targetId) {
                        this.b = typedArrayObtainStyledAttributes.getResourceId(index, this.b);
                    } else if (index == R$styleable.OnClick_clickAction) {
                        this.c = typedArrayObtainStyledAttributes.getInt(index, this.c);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            public void a(MotionLayout motionLayout, int i, b bVar) {
                boolean z;
                View viewFindViewById;
                int i2 = this.b;
                View view = motionLayout;
                if (i2 != -1) {
                    viewFindViewById = motionLayout.findViewById(i2);
                }
                if (view == null) {
                    view = viewFindViewById;
                    Log.e("MotionScene", "OnClick could not find id " + this.b);
                    return;
                }
                int i3 = bVar.d;
                int i4 = bVar.c;
                if (i3 == -1) {
                    view = viewFindViewById;
                    view.setOnClickListener(this);
                    return;
                }
                int i5 = this.c;
                boolean z2 = false;
                if ((i5 & 1) == 0 || i != i3) {
                    view = viewFindViewById;
                    z = false;
                } else {
                    z = true;
                }
                boolean z3 = ((i5 & 1) != 0 && i == i3) | z | ((i5 & 256) != 0 && i == i3) | ((i5 & 16) != 0 && i == i4);
                if ((i5 & 4096) != 0 && i == i4) {
                    z2 = true;
                }
                if (z3 || z2) {
                    view.setOnClickListener(this);
                }
            }

            boolean b(b bVar, MotionLayout motionLayout) {
                b bVar2 = this.a;
                if (bVar2 == bVar) {
                    return true;
                }
                int i = bVar2.c;
                int i2 = this.a.d;
                if (i2 == -1) {
                    return motionLayout.I != i;
                }
                int i3 = motionLayout.I;
                return i3 == i2 || i3 == i;
            }

            public void c(MotionLayout motionLayout) {
                int i = this.b;
                if (i == -1) {
                    return;
                }
                View viewFindViewById = motionLayout.findViewById(i);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(null);
                    return;
                }
                Log.e("MotionScene", " (*)  could not find id " + this.b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.a.j.a;
                if (motionLayout.r0()) {
                    if (this.a.d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.F0(this.a.c);
                            return;
                        }
                        b bVar = new b(this.a.j, this.a);
                        bVar.d = currentState;
                        bVar.c = this.a.c;
                        motionLayout.setTransition(bVar);
                        motionLayout.C0();
                        return;
                    }
                    b bVar2 = this.a.j.c;
                    int i = this.c;
                    boolean z = false;
                    boolean z2 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
                    boolean z3 = ((i & 16) == 0 && (i & 4096) == 0) ? false : true;
                    if (z2 && z3) {
                        b bVar3 = this.a.j.c;
                        b bVar4 = this.a;
                        if (bVar3 != bVar4) {
                            motionLayout.setTransition(bVar4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z3 = false;
                            z = z2;
                        }
                    } else {
                        z = z2;
                    }
                    if (b(bVar2, motionLayout)) {
                        if (z && (this.c & 1) != 0) {
                            motionLayout.setTransition(this.a);
                            motionLayout.C0();
                            return;
                        }
                        if (z3 && (this.c & 16) != 0) {
                            motionLayout.setTransition(this.a);
                            motionLayout.E0();
                        } else if (z && (this.c & 256) != 0) {
                            motionLayout.setTransition(this.a);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z3 || (this.c & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.a);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }
        }

        b(i iVar, b bVar) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList();
            this.l = null;
            this.m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.f178q = 0;
            this.r = 0;
            this.j = iVar;
            this.h = iVar.l;
            if (bVar != null) {
                this.p = bVar.p;
                this.e = bVar.e;
                this.f = bVar.f;
                this.g = bVar.g;
                this.h = bVar.h;
                this.k = bVar.k;
                this.i = bVar.i;
                this.f178q = bVar.f178q;
            }
        }

        private void v(i iVar, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index == R$styleable.Transition_constraintSetEnd) {
                    this.c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        bVar.C(context, this.c);
                        iVar.h.append(this.c, bVar);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.c = iVar.M(context, this.c);
                    }
                } else if (index == R$styleable.Transition_constraintSetStart) {
                    this.d = typedArray.getResourceId(index, this.d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.d);
                    if ("layout".equals(resourceTypeName2)) {
                        androidx.constraintlayout.widget.b bVar2 = new androidx.constraintlayout.widget.b();
                        bVar2.C(context, this.d);
                        iVar.h.append(this.d, bVar2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.d = iVar.M(context, this.d);
                    }
                } else if (index == R$styleable.Transition_motionInterpolator) {
                    int i2 = typedArray.peekValue(index).type;
                    if (i2 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.g = resourceId;
                        if (resourceId != -1) {
                            this.e = -2;
                        }
                    } else if (i2 == 3) {
                        String string = typedArray.getString(index);
                        this.f = string;
                        if (string != null) {
                            if (string.indexOf(WatchConstant.FAT_FS_ROOT) > 0) {
                                this.g = typedArray.getResourceId(index, -1);
                                this.e = -2;
                            } else {
                                this.e = -1;
                            }
                        }
                    } else {
                        this.e = typedArray.getInteger(index, this.e);
                    }
                } else if (index == R$styleable.Transition_duration) {
                    int i3 = typedArray.getInt(index, this.h);
                    this.h = i3;
                    if (i3 < 8) {
                        this.h = 8;
                    }
                } else if (index == R$styleable.Transition_staggered) {
                    this.i = typedArray.getFloat(index, this.i);
                } else if (index == R$styleable.Transition_autoTransition) {
                    this.n = typedArray.getInteger(index, this.n);
                } else if (index == R$styleable.Transition_android_id) {
                    this.a = typedArray.getResourceId(index, this.a);
                } else if (index == R$styleable.Transition_transitionDisable) {
                    this.o = typedArray.getBoolean(index, this.o);
                } else if (index == R$styleable.Transition_pathMotionArc) {
                    this.p = typedArray.getInteger(index, -1);
                } else if (index == R$styleable.Transition_layoutDuringTransition) {
                    this.f178q = typedArray.getInteger(index, 0);
                } else if (index == R$styleable.Transition_transitionFlags) {
                    this.r = typedArray.getInteger(index, 0);
                }
            }
            if (this.d == -1) {
                this.b = true;
            }
        }

        private void w(i iVar, Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transition);
            v(iVar, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public int A() {
            return this.d;
        }

        public j B() {
            return this.l;
        }

        public boolean C() {
            return !this.o;
        }

        public boolean D(int i) {
            return (i & this.r) != 0;
        }

        public void E(int i) {
            this.h = Math.max(i, 8);
        }

        public void F(int i, String str, int i2) {
            this.e = i;
            this.f = str;
            this.g = i2;
        }

        public void G(int i) {
            j jVarB = B();
            if (jVarB != null) {
                jVarB.y(i);
            }
        }

        public void H(int i) {
            this.p = i;
        }

        public void t(c cVar) {
            this.k.add(cVar);
        }

        public void u(Context context, XmlPullParser xmlPullParser) {
            this.m.add(new a(context, this, xmlPullParser));
        }

        public int x() {
            return this.n;
        }

        public int y() {
            return this.c;
        }

        public int z() {
            return this.f178q;
        }

        public b(int i, i iVar, int i2, int i3) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList();
            this.l = null;
            this.m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.f178q = 0;
            this.r = 0;
            this.a = i;
            this.j = iVar;
            this.d = i2;
            this.c = i3;
            this.h = iVar.l;
            this.f178q = iVar.m;
        }

        b(i iVar, Context context, XmlPullParser xmlPullParser) {
            this.a = -1;
            this.b = false;
            this.c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList();
            this.l = null;
            this.m = new ArrayList();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.f178q = 0;
            this.r = 0;
            this.h = iVar.l;
            this.f178q = iVar.m;
            this.j = iVar;
            w(iVar, context, Xml.asAttributeSet(xmlPullParser));
        }
    }
}
